package com.fds.exception;

public class RestaurantFeildNotFoundException extends RuntimeException {
	private String code;
	
	public RestaurantFeildNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
