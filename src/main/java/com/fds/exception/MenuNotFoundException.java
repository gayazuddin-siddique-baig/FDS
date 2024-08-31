package com.fds.exception;

public class MenuNotFoundException extends RuntimeException{
private String code;
	
	public MenuNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
