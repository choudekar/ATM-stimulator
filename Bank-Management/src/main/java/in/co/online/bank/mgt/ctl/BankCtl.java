package in.co.online.bank.mgt.ctl;

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

import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.form.BankForm;
import in.co.online.bank.mgt.service.BankServiceInt;



@Controller
@RequestMapping("/ctl/bank")
public class BankCtl extends BaseCtl {

	@Autowired
	private BankServiceInt service;
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") BankForm form, Model model) {
		if (form.getId() > 0) {
			BankDTO bean=service.findByPK(id);
			form.populate(bean);
		}
		return "bank";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  BankForm form, BindingResult bindingResult,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:bank";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "bank";
				}
				
				BankDTO bean = (BankDTO) form.getDto();
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "Bank update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "Bank Added Successfully!!!!");
				}
				return "bank";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "bank";
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BankForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/bank/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/bank";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BankDTO dto = new BankDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		BankDTO dto=(BankDTO)form.getDto();
		List<BankDTO> list =service.search(dto, pageNo, pageSize);
		List<BankDTO> totallist =service.search(dto);
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
		return "banklist";
	}
	
}
