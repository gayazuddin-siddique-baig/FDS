package com.fds.exception;

public class OrderNotFoundException extends RuntimeException {
	

	public OrderNotFoundException(String message) {
		super(message);
	}

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
