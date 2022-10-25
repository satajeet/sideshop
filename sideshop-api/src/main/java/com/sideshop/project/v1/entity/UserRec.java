package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -801850573233448699L;
	@Id
	private String userId;
	private String userName;
	private String userRoleId;
	private String shopId;

	public UserRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRec(String userId, String userName, String userRoleId, String shopId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRoleId = userRoleId;
		this.shopId = shopId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
