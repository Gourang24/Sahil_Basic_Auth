package com.springboot.microservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.microservices.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
	//	return new ApiResponse(message, false);
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
