package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2228204864034856127L;
	@Id
	private String shopId;
	private String shopName;
	private String shopAddress;

	public Shop() {
		super();
	}

	public Shop(String shopId, String shopName, String shopAddress) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
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
