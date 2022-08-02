package com.plantnursery.plantnursery.seed.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler2 {

	
	@ExceptionHandler(DuplicateSeedIdException.class)
	public ResponseEntity<ExceptionResponse2> handleDuplicateSeedIdException(DuplicateSeedIdException e) {
		ExceptionResponse2 response=new ExceptionResponse2();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse2>(response, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(value=NoSuchSeedException.class)
	public ResponseEntity<ExceptionResponse2> handleNoSuchSeedException(NoSuchSeedException e) {
		ExceptionResponse2 response=new ExceptionResponse2();
		response.setErrorCode("BAD REQUEST");
		response.setErrorMessage(e.getMessage());
	     response.setTimestamp(LocalDateTime.now());
	     return new ResponseEntity<ExceptionResponse2>(response, HttpStatus.BAD_REQUEST);
	     
	}
	@ExceptionHandler(InvalidSeedDataException.class)
	public ResponseEntity<ExceptionResponse2> handleInvalidSeedDataException(InvalidSeedDataException e) {
		ExceptionResponse2 response=new ExceptionResponse2();
        response.setErrorCode("BAD REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse2>(response, HttpStatus.BAD_REQUEST);
		
	}
}
