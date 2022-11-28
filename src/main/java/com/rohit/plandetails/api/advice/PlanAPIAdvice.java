package com.rohit.plandetails.api.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rohit.plandetails.service.exception.NoPlanDetailsFoundByModeException;
import com.rohit.plandetails.service.exception.NoPlanDetailsFoundException;
import com.rohit.plandetails.service.exception.PlanNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PlanAPIAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleResponseBiyd(MethodArgumentNotValidException ex){
		
		List<FieldError> errorslList=ex.getBindingResult().getFieldErrors();
		 String errorMessage = errorslList.stream()
	                .map(fieldError -> fieldError.getField() + " - " + fieldError.getDefaultMessage())
	                .sorted()
	                .collect(Collectors.joining(", "));
		
	        log.info("errorMessage : {} ", errorMessage);
	        
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoPlanDetailsFoundException.class)
	public ResponseEntity<?> handleNotFound(NoPlanDetailsFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoPlanDetailsFoundByModeException.class)
	public ResponseEntity<?> handleNotFound(NoPlanDetailsFoundByModeException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<?> handleNotFound(PlanNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
