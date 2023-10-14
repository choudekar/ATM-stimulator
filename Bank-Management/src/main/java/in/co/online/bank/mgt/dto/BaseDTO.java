package in.co.online.bank.mgt.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * BaseBean JavaBean encapsulates Generic attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList, Comparable<BaseDTO>,Serializable {
	/**
	 * Generic Attribute Id For All Child
	 */
	@Id
    @GenericGenerator(name = "hiIncrement", strategy = "increment")
    @GeneratedValue(generator = "hiIncrement")
    @Column(name = "ID", unique = true, nullable = false)
	protected long id;

	/**
	 * Generic Attribute Created BY For All Child
	 */
	@Column(name="CREATED_BY",length=50)
	protected String createdBy;
	/**
	 * Generic Attribute Modified BY For All Child
	 */
	@Column(name="MODIFIED_BY",length=50)
	protected String modifiedBy;
	/**
	 * Generic Attribute Created Date and TIme For All Child
	 */
	@Column(name="CREATED_DATE_TIME")
	protected Timestamp createdDatetime;
	/**
	 * Generic Attribute Modified Date And TIme For All Child
	 */
	@Column(name="MODIFIED_DATE_TIME")
	protected Timestamp modifiedDatetime;

	/**
	 * accessor
	 */

	/**
	 * @return ID of Child
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param Id
	 *            To set Child ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Created By Child
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param CreatedBy
	 *            To set Child Creatd By
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return Modified By Child
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param Modified
	 *            by To set Child ModifiedBY
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return Created Date And TIme of Child
	 */

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * @param Created
	 *            Date and Time To set Child Created dATE aND tiME
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * @return Modified Date And Time of Child
	 */

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	/**
	 * @param Modified
	 *            By To set Child ModiFied By
	 */
	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	public int compareTo(BaseDTO next) {
        return getValue().compareTo(next.getValue());
    }
}
