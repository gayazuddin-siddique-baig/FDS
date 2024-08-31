package com.fds.exception;

public class RestaurantNotFoundException extends RuntimeException {
	
	private String code;
	
	// constructor
	public RestaurantNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	// getter
	public String getCode() {
		return code;
	}
}