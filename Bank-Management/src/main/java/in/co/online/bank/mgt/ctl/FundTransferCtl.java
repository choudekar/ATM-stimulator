package in.co.online.bank.mgt.ctl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.online.bank.mgt.dto.AccountBalanceDTO;
import in.co.online.bank.mgt.dto.BookTransactionDTO;
import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.form.FundTransferForm;
import in.co.online.bank.mgt.service.AccountBalanceServiceInt;
import in.co.online.bank.mgt.service.BookTransactionServiceInt;
import in.co.online.bank.mgt.service.FundTransferServiceInt;
import in.co.online.bank.mgt.service.UserServiceInt;



@Controller
@RequestMapping("/ctl/fundTransfer")
public class FundTransferCtl extends BaseCtl {

	@Autowired
	private FundTransferServiceInt service;
	
	@Autowired
	private AccountBalanceServiceInt accountBalanceService;
	
	@Autowired
	private BookTransactionServiceInt bookTransactionService;
	
	@Autowired
	private UserServiceInt userService;
	
	@ModelAttribute
	public void preload(Model model) {		

		HashMap<String,String> map=new HashMap<String, String>();
		map.put("Processing","Processing");
		map.put("Completed","Completed");
		map.put("Cancel","Cancel");
		model.addAttribute("type",map);
		
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") FundTransferForm form, Model model) {
		if (form.getId() > 0) {
			FundTransferDTO bean=service.findByPK(id);
			form.populate(bean);
		}
		return "fundTransfer";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  FundTransferForm form, BindingResult bindingResult,HttpSession session,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/fundTransfer";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "fundTransfer";
				}
				
				FundTransferDTO bean = (FundTransferDTO) form.getDto();
				if(bean.getId()>0) {
					if("Cancel".equalsIgnoreCase(bean.getStatus()) || "Processing".equalsIgnoreCase(bean.getStatus())) {
						FundTransferDTO fBean=service.findByPK(bean.getId());
						fBean.setStatus(bean.getStatus());
						service.update(fBean);
						}else {
							AccountBalanceDTO aBean=null;
							 aBean=accountBalanceService.findByAccountNo(bean.getBenAccountNo());
							if(aBean==null){
								AccountBalanceDTO abBean=new AccountBalanceDTO();
								abBean.setAccountNo(bean.getBenAccountNo());
								accountBalanceService.add(abBean);
							}
							FundTransferDTO fBean=service.findByPK(bean.getId());
							BookTransactionDTO bBean=new BookTransactionDTO();
							bBean.setAccountNo(fBean.getByAccountNo());
							bBean.setTransactionType("Debit");
							bBean.setRoutingNo(fBean.getRouting());
							bBean.setTransactionDate(new java.util.Date());
							bBean.setTransactionAmount(fBean.getTraAmount());
							bBean.setTransactionDescription("Fund Transfer");
							bookTransactionService.add(bBean);
							AccountBalanceDTO AccBean=accountBalanceService.findByAccountNo(fBean.getByAccountNo());
							AccBean.setAmount(AccBean.getAmount()-fBean.getTraAmount());
							accountBalanceService.update(AccBean);
							//-----------Benificial
							BookTransactionDTO AcbBean=new BookTransactionDTO();
							AcbBean.setAccountNo(fBean.getBenAccountNo());
							AcbBean.setTransactionType("Credit");
							AcbBean.setRoutingNo(fBean.getRouting());
							AcbBean.setTransactionDate(new java.util.Date());
							AcbBean.setTransactionAmount(fBean.getTraAmount());
							AcbBean.setTransactionDescription("Fund Transfer");
							bookTransactionService.add(AcbBean);
							AccountBalanceDTO AccbBean=accountBalanceService.findByAccountNo(fBean.getBenAccountNo());
							AccbBean.setAmount(AccbBean.getAmount()+fBean.getTraAmount());
							accountBalanceService.update(AccbBean);
							fBean.setStatus(bean.getStatus());
							service.update(fBean);
						}
						model.addAttribute("success", "Data update Successfully!!!!");
				}else {
					UserDTO uBean=(UserDTO)session.getAttribute("user");
					AccountBalanceDTO abBean=accountBalanceService.findByAccountNo(uBean.getAccountNo());
					if(abBean!=null) {
					if(abBean.getAmount()>=bean.getTraAmount()&&abBean.getAmount()>0) {
						UserDTO ubBean=userService.findByAccountNo(bean.getBenAccountNo());
					if(ubBean!=null) {
					bean.setByAccountNo(uBean.getAccountNo());
					long pk=service.add(bean);
					//bean.setId(id);
					model.addAttribute("success", "Data is successfully Saved");
					}else {
						model.addAttribute("error", "Beneficial Account No Is not Register please inter Correct Account No");
					}
					}else {
						model.addAttribute("error", "Insufficient Account Balance");
					}
					}else {
						model.addAttribute("error", "Insufficient Account Balance");
					}
				}
				return "fundTransfer";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "fundTransfer";
		}
		return "fundTransfer";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") FundTransferForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/fundTransfer/ctl/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/fundTransfer";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					FundTransferDTO dto = new FundTransferDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		FundTransferDTO dto=(FundTransferDTO)form.getDto();
		
		UserDTO uBean=(UserDTO)session.getAttribute("user");
		if(uBean.getRoleId()==2) {
			dto.setByAccountNo(uBean.getAccountNo());
		}
		
		List<FundTransferDTO> list =service.search(dto, pageNo, pageSize);
		List<FundTransferDTO> totallist =service.search(dto);
		model.addAttribute("list", list);
		
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "fundTransferList";
	}
	
}
