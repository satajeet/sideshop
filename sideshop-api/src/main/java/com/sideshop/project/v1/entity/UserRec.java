package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -801850573233448699L;
	@BsonId
	private String _id;
	private String userName;
	private String loginName;
	private String password;
	private String passwordHint;
	private String userRoleId;

	public UserRec() {
		super();
	}

	public UserRec(String _id, String userName, String loginName, String password, String passwordHint,
			String userRoleId) {
		super();
		this._id = _id;
		this.userName = userName;
		this.userRoleId = userRoleId;
		this.loginName = loginName;
		this.password = password;
		this.passwordHint = passwordHint;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
}
