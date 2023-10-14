package in.co.online.bank.mgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role JavaBean encapsulates Role attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@Entity
@Table(name="B_ROLE")
public class RoleDTO extends BaseDTO {
	/**
	 * Predefined Role constants
	 */
	public static final int ADMIN = 1;
	public static final int USER = 2;
	

	/**
	 * Role Name
	 */
	@Column(name="Name",length=225)
	private String name;

	/**
	 * Role Description
	 */
	@Column(name="Description",length=225)
	private String description;

	/**
	 * accessor
	 */

	/**
	 * @return Name of Role
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param to
	 *            set Name Of Role
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Description of Role
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * @param to
	 *            set Description Of Role
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}
}
