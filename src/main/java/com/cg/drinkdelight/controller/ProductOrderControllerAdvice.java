package com.cg.drinkdelight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.drinkdelight.exception.ProductOrderException;

@RestControllerAdvice
public class ProductOrderControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptionHandler(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductOrderException.class)
	public ResponseEntity<String> orderExceptionHandler(ProductOrderException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
