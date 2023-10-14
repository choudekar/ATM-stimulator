package in.co.online.bank.mgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="B_Bank")
public class BankDTO extends BaseDTO {
	
	@Column(name="Name",length=225)
	private String name;
	@Column(name="IFSE_Code",length=225)
	private String IFSECode;
	@Column(name="Description",length=225)
	private String description;
	@Column(name="Short_Code",length=225)
	private String shortCode;
	
	
	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

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

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
