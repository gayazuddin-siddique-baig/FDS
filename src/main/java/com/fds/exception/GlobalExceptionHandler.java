package com.fds.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// method to handle RestaurantNotFoundException
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleRestaurantNotFoundException(RestaurantNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
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
	/*
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleURLNotFoundException(Exception e) {
		ErrorResponse error = new ErrorResponse("GETFAILS", "Incorrect url");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
*/
	//validation failed exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
		ErrorResponse error = new ErrorResponse("VALIDATIONFAILS", "Please provide the valid data and do not pass empty string");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	//invalid argument type 
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleArgumentMismatchException(MethodArgumentTypeMismatchException e) {
		ErrorResponse error = new ErrorResponse("VALIDATIONFAILS", "Please provide the valid data type");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.EXPECTATION_FAILED);
	}
	
	//invalid method type 
		@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
		public ResponseEntity<ErrorResponse> handleMethodNotAllowedException(HttpRequestMethodNotSupportedException e) {
			ErrorResponse error = new ErrorResponse("VALIDATIONFAILS", "Invalid method type");
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
		}
	
	//3 driver not found
	@ExceptionHandler(DeliveryDriverNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDriverNotFoundException(DeliveryDriverNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//4
	@ExceptionHandler(AssingedDriverToOrderException.class)
	public ResponseEntity<ErrorResponse> handleAssingDriverException(AssingedDriverToOrderException e) {
		ErrorResponse error = new ErrorResponse("PUTFAILS", e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//5
	@ExceptionHandler(MenuNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMenuNotFoundException(MenuNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//6
	@ExceptionHandler(RatingsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleReviewNotFoundException(RatingsNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getCode(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//---------------end >>>>

}
