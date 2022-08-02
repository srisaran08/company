package com.plantnursery.plantnursery.planter.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler3 {

	
	@ExceptionHandler(DuplicatePlanterIdException.class)
	public ResponseEntity<ExceptionResponse3> handleDuplicatePlanterIdException(DuplicatePlanterIdException e) {
		ExceptionResponse3 response=new ExceptionResponse3();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse3>(response, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(value=NoSuchPlanterException.class)
	public void handleNoSuchPlanterException(NoSuchPlanterException e) {
		ExceptionResponse3 response=new ExceptionResponse3();
		response.setErrorCode("BAD REQUEST");
		response.setErrorMessage(e.getMessage());
	     response.setTimestamp(LocalDateTime.now());
		
	     
	}
	
	@ExceptionHandler(InvalidPlanterDataException.class)
	public ResponseEntity<ExceptionResponse3> handleInvalidPlanterDataException(InvalidPlanterDataException e) {
		ExceptionResponse3 response=new ExceptionResponse3();
        response.setErrorCode("BAD REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse3>(response, HttpStatus.BAD_REQUEST);
		
	}
}

