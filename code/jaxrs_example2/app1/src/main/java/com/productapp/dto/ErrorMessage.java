package com.productapp.dto;

public class ErrorMessage {
	
	private String message;
	private int statusCode;
	private String toContact;
	
	public ErrorMessage(String message, int statusCode, String toContact) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.toContact = toContact;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	
	
	
}
