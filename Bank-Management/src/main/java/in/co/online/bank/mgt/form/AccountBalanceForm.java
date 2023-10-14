package in.co.online.bank.mgt.form;

import javax.persistence.Column;

import in.co.online.bank.mgt.dto.AccountBalanceDTO;
import in.co.online.bank.mgt.dto.BaseDTO;

public class AccountBalanceForm extends BaseForm {

	private long accountNo;
	private long amount;
	
	
	
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public BaseDTO getDto() {
		AccountBalanceDTO dto=new AccountBalanceDTO();
		dto.setAccountNo(accountNo);
		dto.setAmount(amount);
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AccountBalanceDTO dto=(AccountBalanceDTO)bDto;
		accountNo=dto.getAccountNo();
		amount=dto.getAmount();
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
