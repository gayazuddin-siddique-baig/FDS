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
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// method to handle NoRestaurantsFoundException
	@ExceptionHandler(NoRestaurantsFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoRestaurantsFoundException(NoRestaurantsFoundException e) {
		ErrorResponse error = new ErrorResponse("GETALLFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// method to handle CustomerNotFoundException
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// method to handle OrderNotFoundException
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//global url not found
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleURLNotFoundException(Exception e) {
		ErrorResponse error = new ErrorResponse("GETFAILS", "Incorrect url");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
