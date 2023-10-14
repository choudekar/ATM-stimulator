package in.co.online.bank.mgt.form;



import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.util.DataUtility;





public class MyProfileForm extends BaseForm {

	@NotEmpty
	@Pattern(regexp = "^([A-Za-z ]*)*$")
	private String firstName;
	
	@NotEmpty
	@Pattern(regexp = "^([A-Za-z ]*)*$")
	private String lastName;

	@NotEmpty
	private String login;
	@NotEmpty
	private String gender;

	@NotEmpty
	@Pattern(regexp="(^[7-9][0-9]{9})*$")
	private String mobileNo;

	@NotEmpty
	private String dob;
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setMobileNo(mobileNo);
		dto.setLogin(login);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(DataUtility.getDate(dob));
		dto.setGender(gender);
		return dto;
	}

	
	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		mobileNo = dto.getMobileNo();
		login = dto.getLogin();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		dob = DataUtility.getStringDate(dto.getDob());
		gender = dto.getGender();

	}

}
