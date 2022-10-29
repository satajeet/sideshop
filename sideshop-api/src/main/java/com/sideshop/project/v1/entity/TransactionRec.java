package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TransactionRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8985117821471794083L;
	@BsonId
	private String _id;
	private String shopId;
	private String stockId;
	private int quantity;
	private float price;
	private String statusId;

	public TransactionRec() {
		super();
	}

	public TransactionRec(String _id, String shopId, String stockId, int quantity, float price, String statusId) {
		super();
		this._id = _id;
		this.shopId = shopId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.price = price;
		this.statusId = statusId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

}
