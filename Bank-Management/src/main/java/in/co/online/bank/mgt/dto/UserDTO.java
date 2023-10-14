package in.co.online.bank.mgt.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User JavaBean encapsulates TimeTable attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@Entity
@Table(name="B_USER")
public class UserDTO extends BaseDTO {

	/**
	 * First Name of User
	 */
	@Column(name="first_Name",length=225)
	private String firstName;
	/**
	 * Last Name of User
	 */
	@Column(name="last_Name",length=225)
	private String lastName;
	/**
	 * Login of User
	 */
	@Column(name="Login",length=225)
	private String login;
	/**
	 * Password of User
	 */
	@Column(name="Password",length=225)
	private String password;
	/**
	 * Confirm Password of User
	 */
	private String confirmPassword;
	/**
	 * Date of Birth of User
	 */
	@Column(name="dob")
	private Date dob;
	/**
	 * MobielNo of User
	 */
	@Column(name="Mobile_No",length=225)
	private String mobileNo;
	/**
	 * Role of User
	 */
	@Column(name="role_Id")
	private long roleId;
	
	/**
	 * Gender of User
	 */
	@Column(name="Gender",length=225)
	private String gender;
	/**
	 * Last login timestamp
	 */
	@Column(name="account_No")
	private long accountNo;
	@Column(name="bank_Id")
	private long bankId;
	@Column(name="bank_Name",length=225)
	private String bankName;
	@Column(name="Type_Of_Account")
	private String typeOfAccount;
	
	@Column(name="Title",length=225)
	private String title;
	@Column(name="Account_Name",length=225)
	private String accountName;
	@Column(name="Fax",length=225)
	private String fax;
	@Column(name="Nationality",length=225)
	private String nationality;
	@Column(name="User_Image",length=225)
	private String userImage;
	@Column(name="email_Id",length=225)
	private String emailId;
	
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * accessor
	 */

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
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

	/**
	 * @return FirstName Of User
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param FirstName
	 *            To set User FirstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return LastName Of User
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param LastName
	 *            To set User LastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Login id Of User
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param Login
	 *            Id To set User Login ID
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Password Of User
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param Password
	 *            To set User Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Confirm Password Of User
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param Confirm
	 *            PAssword To set User Confirm Password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return Date Of Birth Of User
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param Date
	 *            Of Birth To set User Date Of Birth
	 */

	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return Mobile No Of User
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param Mobile
	 *            No To set User Mobile No
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return ROle Id Of User
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param Role
	 *            Id To set User ROle Id
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return unSuccessfulLogin Of User
	 */
	

	/**
	 * @return unSuccessfulLogin Of User
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param Gender
	 *            To set User Gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return lastLogin Of User
	 */


	public String getKey() {
		return id + "";
	}

	public String getValue() {

		return firstName + " " + lastName;
	}
}
