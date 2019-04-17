package com.cg.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// Global excpetion handler
@ControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler({Exception.class})
	protected ResponseEntity<String> handleConflict(Exception ex, WebRequest req) {
		String msg= ex.getMessage();
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
}
