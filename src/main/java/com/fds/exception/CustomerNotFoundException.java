package com.fds.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private String code;
	
	// constructor
	public CustomerNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	// getter
	public String getCode() {
		return code;
	}
}
