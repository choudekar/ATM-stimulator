package in.co.online.bank.mgt.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.util.DataUtility;





public class UserForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name invalid")
	private String firstName;
	
	
	@NotEmpty(message = "Last Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$" ,message = "Last Name is invalid")
	private String lastName;

	@NotEmpty(message = "Login Id is required")
	private String login;

	@NotEmpty(message = "Password is required")
	@Pattern(regexp = "(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$" ,message = "Password is invalid")
	private String password;

	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;

	@NotEmpty(message = "Dob is required")
	private String dob;

	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp = "(^[7-9][0-9]{9})*$",message = "Mobile No is invalid")
	private String mobileNo;

	@NotEmpty(message = "Gender is required")
	private String gender;
	
	private String accountNo;
	
	@Min(value = 1,message ="Bank Name is required")
	private long bankId;
	
	private String bankName;
	@NotEmpty(message = "Account Type is required")
	private String typeOfAccount;
	@NotEmpty(message = "Title is required")
	private String title;
	@NotEmpty(message = "Account Name is required")
	private String accountName;
	@NotEmpty(message = "Fax is required")
	private String fax;
	@NotEmpty(message = "Nationality is required")
	private String nationality;
	private String userImage;
	@NotEmpty(message = "Email Id  is required")
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email Id invalid")
	private String emailId;


	private long roleId;

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

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	



	public String getGender() {
		return gender;
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
	
	

	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);

		dto.setFirstName(firstName);
		dto.setLastName(lastName);

		dto.setDob(DataUtility.getDate(dob));

		dto.setLogin(login);
		dto.setPassword(password);
		dto.setMobileNo(mobileNo);
		dto.setGender(gender);
		dto.setRoleId(roleId);
		dto.setAccountNo(DataUtility.getLong(accountNo));
		dto.setBankId(bankId);
		dto.setBankName(bankName);
		dto.setTypeOfAccount(typeOfAccount);
		dto.setTitle(title);
		dto.setAccountName(accountName);
		dto.setFax(fax);
		dto.setNationality(nationality);
		dto.setEmailId(emailId);

		return dto;
	}

	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		id = dto.getId();
		accountNo=String.valueOf(dto.getAccountNo());
		bankId=dto.getBankId();
		bankName=dto.getBankName();
		typeOfAccount=dto.getTypeOfAccount();
		title=dto.getTitle();
		accountName=dto.getAccountName();
		fax=dto.getFax();
		nationality=dto.getNationality();
		emailId=dto.getEmailId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		dob = DataUtility.getStringDate(dto.getDob());
		login = dto.getLogin();
		password = dto.getPassword();
		confirmPassword = dto.getPassword();
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		roleId = dto.getRoleId();

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
