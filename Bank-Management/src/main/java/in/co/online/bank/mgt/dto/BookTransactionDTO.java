package in.co.online.bank.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Book_Transaction")
public class BookTransactionDTO  extends BaseDTO{

	@Column(name="Account_No")
	private long accountNo;
	@Column(name="Acc_Holder_Name",length=225)
	private String AccHolderName;
	@Column(name="Transaction_type",length=225)
	private String transactionType;
	@Column(name="transaction_Amount")
	private long transactionAmount;
	@Column(name="bank_Id")
	private long bankId;
	@Column(name="Bank_Name",length=225)
	private String bankName;
	@Column(name="rounting_No",length=225)
	private String routingNo;
	@Column(name="transaction_date")
	private Date transactionDate;
	@Column(name="transaction_Description",length=225)
	private String transactionDescription;
	
	
	
	
	

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccHolderName() {
		return AccHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		AccHolderName = accHolderName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
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

	public String getRoutingNo() {
		return routingNo;
	}

	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
