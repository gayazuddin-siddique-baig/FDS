package com.fds.exception;

public class ReviewNotFoundException extends RuntimeException {
	private String code;
	
	public ReviewNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
