package in.co.online.bank.mgt.ctl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.form.BookTransactionForm;
import in.co.online.bank.mgt.service.AccountBalanceServiceInt;
import in.co.online.bank.mgt.service.BookTransactionServiceInt;



@Controller
@RequestMapping("/ctl/bookTransaction")
public class BookTransactionCtl extends BaseCtl {

	@Autowired
	private BookTransactionServiceInt service;
	
	@Autowired
	private AccountBalanceServiceInt accountBalanceService;
	
	@ModelAttribute
	public void preload(Model model) {		

		HashMap<String,String> map=new HashMap<String, String>();
		map.put("Credit","Credit");
		map.put("Debit","Debit");
		model.addAttribute("type",map);
		
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") BookTransactionForm form, Model model) {
		if (form.getId() > 0) {
			BookTransactionDTO bean=service.findByPK(id);
			form.populate(bean);
		}
		return "bookTransaction";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  BookTransactionForm form, BindingResult bindingResult,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/bookTransaction";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "bookTransaction";
				}
				
				BookTransactionDTO bean = (BookTransactionDTO) form.getDto();
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "BookTransaction update Successfully!!!!");
				}else {
				long pk=service.add(bean);
				if (pk > 0) {
					AccountBalanceDTO aBean = accountBalanceService.findByAccountNo(bean.getAccountNo());
					if (aBean != null) {
							if("Credit".equalsIgnoreCase(bean.getTransactionType())) {
								aBean.setAmount(aBean.getAmount()+bean.getTransactionAmount());
								accountBalanceService.update(aBean);
							}else if("Debit".equalsIgnoreCase(bean.getTransactionType())) {
								aBean.setAmount(aBean.getAmount()-bean.getTransactionAmount());
								accountBalanceService.update(aBean);
							}
					} else {
						AccountBalanceDTO acBean = new AccountBalanceDTO();
						acBean.setAccountNo(bean.getAccountNo());
						acBean.setAmount(bean.getTransactionAmount());
						accountBalanceService.add(acBean);
					}
				}
				model.addAttribute("success", "BookTransaction Added Successfully!!!!");
				}
				return "bookTransaction";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "bookTransaction";
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BookTransactionForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/bookTransaction/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/bookTransaction";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BookTransactionDTO dto = new BookTransactionDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		BookTransactionDTO dto=(BookTransactionDTO)form.getDto();
		UserDTO uBean=(UserDTO)session.getAttribute("user");
		if(uBean.getRoleId()==2) {
			dto.setAccountNo(uBean.getAccountNo());
		}
		List<BookTransactionDTO> list =service.search(dto, pageNo, pageSize);
		List<BookTransactionDTO> totallist =service.search(dto);
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
		return "bookTransactionList";
	}
	
}
