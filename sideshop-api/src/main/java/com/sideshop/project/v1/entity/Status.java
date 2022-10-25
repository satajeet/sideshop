package com.sideshop.project.v1.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7051251179434509177L;
	@Id
	private String statusId;
	private String statusName;

	public Status() {
		super();
	}

	public Status(String statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
