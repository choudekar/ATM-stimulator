package in.co.online.bank.mgt.form;

import javax.persistence.Column;

import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.dto.BaseDTO;

public class BankForm extends BaseForm {

	private String name;
	private String IFSECode;
	private String description;
	private String shortCode;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIFSECode() {
		return IFSECode;
	}

	public void setIFSECode(String iFSECode) {
		IFSECode = iFSECode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	@Override
	public BaseDTO getDto() {
		BankDTO dto=new BankDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setIFSECode(IFSECode);
		dto.setDescription(description);
		dto.setShortCode(shortCode);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BankDTO dto=(BankDTO)bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		name=dto.getName();
		IFSECode=dto.getIFSECode();
		description=dto.getDescription();
		shortCode=dto.getShortCode();
		
	}

}
