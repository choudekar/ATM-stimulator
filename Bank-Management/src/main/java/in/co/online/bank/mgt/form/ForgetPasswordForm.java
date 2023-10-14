package in.co.online.bank.mgt.form;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.UserDTO;




public class ForgetPasswordForm extends BaseForm {

	@NotEmpty
	private String login;
	
	
	
	

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public BaseDTO getDto() {
	
		UserDTO dto = new UserDTO();
		dto.setLogin(login);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		
	}

}
