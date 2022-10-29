package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2228204864034856127L;
	@BsonId
	private String _id;
	private String shopName;
	private String shopAddress;

	public Shop() {
		super();
	}

	public Shop(String _id, String shopName, String shopAddress) {
		super();
		this._id = _id;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
}
