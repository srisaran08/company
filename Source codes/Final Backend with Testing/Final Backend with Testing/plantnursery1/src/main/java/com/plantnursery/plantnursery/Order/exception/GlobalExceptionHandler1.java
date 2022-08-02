package com.plantnursery.plantnursery.Order.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler1 {

	
	@ExceptionHandler(DuplicateOrderIdException.class)
	public ResponseEntity<ExceptionResponse1> handleDuplicateOrderIdException(DuplicateOrderIdException e) {
		ExceptionResponse1 response=new ExceptionResponse1();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse1>(response, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(value=NoSuchOrderException.class)
	public void handleNoSuchOrderException(NoSuchOrderException e) {
		ExceptionResponse1 response=new ExceptionResponse1();
		response.setErrorCode("BAD REQUEST");
		response.setErrorMessage(e.getMessage());
	     response.setTimestamp(LocalDateTime.now());
	     
		
	}
	@ExceptionHandler(InvalidOrderDataException.class)
	public ResponseEntity<ExceptionResponse1> handleInvalidOrderDataException(InvalidOrderDataException e) {
		ExceptionResponse1 response=new ExceptionResponse1();
        response.setErrorCode("BAD REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse1>(response, HttpStatus.BAD_REQUEST);
}
}
