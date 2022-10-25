package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7046831310283756686L;
	@Id
	private String userRoleId;
	private String userRoleName;
	private String userRoleRights;

	public UserRole() {
		super();
	}

	public UserRole(String userRoleId, String userRoleName, String userRoleRights) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
		this.userRoleRights = userRoleRights;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getUserRoleRights() {
		return userRoleRights;
	}

	public void setUserRoleRights(String userRoleRights) {
		this.userRoleRights = userRoleRights;
	}

}
