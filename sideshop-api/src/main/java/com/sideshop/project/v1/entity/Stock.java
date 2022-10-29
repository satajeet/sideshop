package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 576215622080347514L;
	@BsonId
	private String _id;
	private String stockName;
	private int stockQuantity;
	private float price;
	private String shopId;

	public Stock() {
		super();
	}

	public Stock(String _id, String stockName, int stockQuantity, float price, String shopId) {
		super();
		this._id = _id;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.price = price;
		this.shopId = shopId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
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
