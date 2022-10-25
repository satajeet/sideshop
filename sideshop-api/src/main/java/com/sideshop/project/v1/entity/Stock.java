package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 576215622080347514L;
	@Id
	private String stockId;
	private String stockName;
	private String stockQuantity;
	private float price;
	private String shopId;

	public Stock() {
		super();
	}

	public Stock(String stockId, String stockName, String stockQuantity, float price, String shopId) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.price = price;
		this.shopId = shopId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
