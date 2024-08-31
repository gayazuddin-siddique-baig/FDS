package com.fds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// method to handle RestaurantNotFoundException
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleRestaurantNotFoundException(RestaurantNotFoundException e) {
		ErrorResponse error = new ErrorResponse("ADDFAILS", "Restaurant not found");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
}
