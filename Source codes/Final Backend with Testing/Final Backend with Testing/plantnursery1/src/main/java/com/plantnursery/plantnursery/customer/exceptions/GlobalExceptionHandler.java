package com.plantnursery.plantnursery.customer.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DuplicateCustomerIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateCustomerIdException(DuplicateCustomerIdException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<ExceptionResponse> handleNoSuchCustomerException(NoSuchCustomerException e) {
		ExceptionResponse response=new ExceptionResponse();
		 response.setErrorCode("DATA INVALID");
		 response.setErrorMessage(e.getMessage());
	     response.setTimestamp(LocalDateTime.now());
	     return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCustomerDataException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidCustomerDataExceptionException(InvalidCustomerDataException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("BAD REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
		
	}
}

