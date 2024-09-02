package com.fds.exception;

public class DeliveryDriverNotFoundException extends RuntimeException {

	private String code;
	
	public DeliveryDriverNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
