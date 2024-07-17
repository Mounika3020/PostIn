package com.iss.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyMessageModel{
	@Id
	private String frm;
	private String message;
	private String too;
	public String getFrm() {
		return frm;
	}
	public void setFrm(String frm) {
		this.frm = frm;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToo() {
		return too;
	}
	public void setToo(String too) {
		this.too = too;
	}
}