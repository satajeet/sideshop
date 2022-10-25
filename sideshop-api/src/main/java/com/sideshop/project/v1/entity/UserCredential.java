package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserCredential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -378046805514668985L;
	@Id
	private String userCredentialId;
	private String userId;
	private String loginName;
	private String password;
	private String passwordHint;

	public UserCredential() {
		super();
	}

	public UserCredential(String userCredentialId, String userId, String loginName, String password,
			String passwordHint) {
		super();
		this.userCredentialId = userCredentialId;
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
		this.passwordHint = passwordHint;
	}

	public String getUserCredentialId() {
		return userCredentialId;
	}

	public void setUserCredentialId(String userCredentialId) {
		this.userCredentialId = userCredentialId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
