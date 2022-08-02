package com.plantnursery.plantnursery.plant.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler4 {
	
	@ExceptionHandler(DuplicatePlantIdException.class)
	public ResponseEntity<ExceptionResponse4> handleDuplicatePlantIdException(DuplicatePlantIdException e) {
		ExceptionResponse4 response=new ExceptionResponse4();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse4>(response, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(NoSuchPlantException.class)
	public ResponseEntity<ExceptionResponse4> handleNoSuchPlantException(NoSuchPlantException e) {
		ExceptionResponse4 response=new ExceptionResponse4();
		response.setErrorCode("DATA INVALID");
		response.setErrorMessage(e.getMessage());
	     response.setTimestamp(LocalDateTime.now());
	     return new ResponseEntity<ExceptionResponse4>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPlantDataException.class)
	public ResponseEntity<ExceptionResponse4> handleInvalidPlantDataExceptionException(InvalidPlantDataException e) {
		ExceptionResponse4 response=new ExceptionResponse4();
        response.setErrorCode("BAD REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse4>(response, HttpStatus.BAD_REQUEST);
		
	}

}
