package com.fds.exception;

public class NoRestaurantsFoundException extends RuntimeException {
	
	public NoRestaurantsFoundException(String message) {
		super(message);
	}
}