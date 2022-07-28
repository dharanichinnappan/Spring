package com.dharani.Restful.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Code to handle thrown exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		// StudentErrorResponse --> type of response body
		// StudentNotFoundException --> Exception to handle/catch

		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Code to handle other exception

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(e.getMessage()); // --> We can change message.
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
