package com.app.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.RailNotFoundException;
import com.app.dto.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(RailNotFoundException.class)
//	public ResponseEntity<?> handleRailNotFoundException(RailNotFoundException e)
//	{
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
//	}
	
	
	
	
	@ExceptionHandler(RailNotFoundException.class)
	public ResponseEntity<?> handleRailNotFoundException(RailNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}

	
	
}
