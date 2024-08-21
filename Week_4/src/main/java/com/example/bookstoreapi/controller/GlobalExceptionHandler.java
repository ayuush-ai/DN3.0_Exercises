package com.example.bookstoreapi.controller;

public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                         .body(ex.getMessage());
	}

}
