package com.fds.exception;

public class MenuItemsFieldNotFoundException extends RuntimeException {

	private String code;
	
	public MenuItemsFieldNotFoundException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
