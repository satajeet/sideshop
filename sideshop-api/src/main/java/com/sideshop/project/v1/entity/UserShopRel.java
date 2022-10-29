package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserShopRel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5598001187791643056L;
	@BsonId
	private String _id;
	private String userId;
	private String shopId;

	public UserShopRel() {
		super();
	}

	public UserShopRel(String _id, String userId, String shopId) {
		super();
		this._id = _id;
		this.userId = userId;
		this.shopId = shopId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
}
