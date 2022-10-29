package com.sideshop.project.v1.entity;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7051251179434509177L;
	@BsonId
	private String _id;
	private String statusName;

	public Status() {
		super();
	}

	public Status(String _id, String statusName) {
		super();
		this._id = _id;
		this.statusName = statusName;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
