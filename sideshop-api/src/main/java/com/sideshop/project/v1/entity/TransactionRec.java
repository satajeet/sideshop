package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TransactionRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8985117821471794083L;
	@Id
	private String transactionId;
	private String shopId;
	private String stockId;
	private int quantity;
	private float price;
	private String statusId;

	public TransactionRec() {
		super();
	}

	public TransactionRec(String transactionId, String shopId, String stockId, int quantity, float price,
			String statusId) {
		super();
		this.transactionId = transactionId;
		this.shopId = shopId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.price = price;
		this.statusId = statusId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
