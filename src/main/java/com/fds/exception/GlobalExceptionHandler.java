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
		
		ErrorResponse error = new ErrorResponse("ADDFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	

	//<<<<-----------------pankaj
	//1
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
		ErrorResponse error = new ErrorResponse("GETFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	//global url not found
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleURLNotFoundException(Exception e) {
		ErrorResponse error = new ErrorResponse("GETFAILS", "Incorrect url");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	//3 driver not found
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDriverNotFoundException(DriverNotFoundException e) {
		ErrorResponse error = new ErrorResponse("GETFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//4
	@ExceptionHandler(AssingedDriverToOrderException.class)
	public ResponseEntity<ErrorResponse> handleAssingDriverException(AssingedDriverToOrderException e) {
		ErrorResponse error = new ErrorResponse("PUTFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//5
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException e) {
		ErrorResponse error = new ErrorResponse("PUTFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//---------------end >>>>

}
