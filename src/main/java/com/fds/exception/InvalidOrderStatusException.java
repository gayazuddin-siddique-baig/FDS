package com.fds.exception;

public class InvalidOrderStatusException extends RuntimeException {
	private String code;
	
	public InvalidOrderStatusException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
