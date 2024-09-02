package com.fds.exception;

public class RatingsNotFoundException extends RuntimeException {
	
	private String code;
	
	public RatingsNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}