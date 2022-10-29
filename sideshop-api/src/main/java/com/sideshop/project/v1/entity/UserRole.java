package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7046831310283756686L;
	@BsonId
	private String _id;
	private String userRoleName;
	private String userRoleRights;

	public UserRole() {
		super();
	}

	public UserRole(String _id, String userRoleName, String userRoleRights) {
		super();
		this._id = _id;
		this.userRoleName = userRoleName;
		this.userRoleRights = userRoleRights;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
