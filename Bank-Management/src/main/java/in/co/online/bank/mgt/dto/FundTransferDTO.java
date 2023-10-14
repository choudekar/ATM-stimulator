package in.co.online.bank.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="B_FundTransfer")
public class FundTransferDTO extends BaseDTO {
	
	@Column(name="by_AccountNo")
	private long byAccountNo;
	@Column(name="by_acc_holder_Name",length=225)
	private String byAccHolderName;
	@Column(name="transfer_Date")
	private Date transferDate;
	@Column(name="Ben_account_No")
	private long benAccountNo;
	@Column(name="Ben_Acc_Holder_Name",length=225)
	private String benAccHolderName;
	@Column(name="Bank_Name",length=225)
	private String bankName;
	@Column(name="routing",length=225)
	private String routing;
	@Column(name="Tra_Amount")
	private long traAmount;
	@Column(name="Status",length=225)
	private String status;
	
	
	
	
	
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getByAccountNo() {
		return byAccountNo;
	}

	public void setByAccountNo(long byAccountNo) {
		this.byAccountNo = byAccountNo;
	}

	public String getByAccHolderName() {
		return byAccHolderName;
	}

	public void setByAccHolderName(String byAccHolderName) {
		this.byAccHolderName = byAccHolderName;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public long getBenAccountNo() {
		return benAccountNo;
	}

	public void setBenAccountNo(long benAccountNo) {
		this.benAccountNo = benAccountNo;
	}

	public String getBenAccHolderName() {
		return benAccHolderName;
	}

	public void setBenAccHolderName(String benAccHolderName) {
		this.benAccHolderName = benAccHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRouting() {
		return routing;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}

	public long getTraAmount() {
		return traAmount;
	}

	public void setTraAmount(long traAmount) {
		this.traAmount = traAmount;
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
