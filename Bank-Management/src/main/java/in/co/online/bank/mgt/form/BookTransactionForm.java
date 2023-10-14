package in.co.online.bank.mgt.form;


import javax.validation.constraints.NotEmpty;

import in.co.online.bank.mgt.dto.BaseDTO;
import in.co.online.bank.mgt.dto.BookTransactionDTO;
import in.co.online.bank.mgt.util.DataUtility;

public class BookTransactionForm extends BaseForm {

	@NotEmpty(message = "Account No is required")
	private String accountNo;
	
	private String accHolderName;
	@NotEmpty(message = "Transaction is required")
	private String transactionType;
	@NotEmpty(message = "Transaction Amount is required")
	private String transactionAmount;
	private long bankId;
	private String bankName;
	@NotEmpty(message = "Transaction Date is required")
	private String transactionDate;
	@NotEmpty(message = "Transaction Description is required")
	private String transactionDescription;
	@NotEmpty(message = "Routing is required")
	private String  routing;
	
	
	
	
	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	

	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
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

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public BaseDTO getDto() {
		BookTransactionDTO dto=new BookTransactionDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setAccountNo(DataUtility.getLong(accountNo));
		dto.setAccHolderName(accHolderName);
		dto.setTransactionType(transactionType);
		dto.setTransactionAmount(DataUtility.getLong(transactionAmount));
		dto.setBankId(bankId);
		dto.setBankName(bankName);
		dto.setTransactionDate(DataUtility.getDate(transactionDate));
		dto.setTransactionDescription(transactionDescription);
		dto.setRoutingNo(routing);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BookTransactionDTO dto=(BookTransactionDTO)bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		accountNo=String.valueOf(dto.getAccountNo());
		accHolderName=dto.getAccHolderName();
		transactionType=dto.getTransactionType();
		transactionAmount=String.valueOf(dto.getTransactionAmount());
		routing=dto.getRoutingNo();
		bankId=dto.getBankId();
		bankName=dto.getBankName();
		transactionDate=DataUtility.getStringDate(dto.getTransactionDate());
		transactionDescription=dto.getTransactionDescription();
	}

}
