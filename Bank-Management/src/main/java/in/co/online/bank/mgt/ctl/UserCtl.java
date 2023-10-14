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

import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.form.UserForm;
import in.co.online.bank.mgt.service.BankServiceInt;
import in.co.online.bank.mgt.service.UserServiceInt;



@Controller
@RequestMapping("/ctl/user")
public class UserCtl extends BaseCtl {

	@Autowired
	private UserServiceInt service;
	
	@Autowired
	private BankServiceInt bankService;
	
	@ModelAttribute
	public void preload(Model model) {		

		HashMap<String,String> map=new HashMap<String, String>();
		map.put("Saving","Saving");
		map.put("Current","Current");
		map.put("Fix Diposite","Fix Diposite");
		model.addAttribute("type",map);
		
		model.addAttribute("bank",bankService.list());
		
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		
		model.addAttribute("gender",genderMap);
		
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") UserForm form, Model model) {
		if (form.getId() > 0) {
			UserDTO bean=service.findByPk(id);
			form.populate(bean);
		}
		return "user";
	}
	
	
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  UserForm form, BindingResult bindingResult,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/user";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "user";
				}
				
				UserDTO bean = (UserDTO) form.getDto();
				if(bean.getId()>0) {
					bean.setRoleId(2L);
					service.update(bean);
					model.addAttribute("success", "User update Successfully!!!!");
				}else {
				bean.setRoleId(2L);
				service.add(bean);
				model.addAttribute("success", "User Added Successfully!!!!");
				}
				return "user";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "user";
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/user/ctl/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/user";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		UserDTO dto=(UserDTO)form.getDto();
		dto.setRoleId(2L);
		List<UserDTO> list =service.search(dto, pageNo, pageSize);
		List<UserDTO> totallist =service.search(dto);
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
		return "userlist";
	}
	
}
