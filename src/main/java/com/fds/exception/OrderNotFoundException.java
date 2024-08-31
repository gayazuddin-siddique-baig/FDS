package com.fds.exception;

public class OrderNotFoundException extends RuntimeException {
	
	private String code;
	
	// constructor
	public OrderNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	// getter
	public String getCode() {
		return code;
	}
}
