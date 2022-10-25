package com.sideshop.project.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SideshopExceptionController {

	@ExceptionHandler(value = SideshopNotfoundException.class)
	public ResponseEntity<Object> exception(SideshopNotfoundException sideshopNotfoundException) {
		return new ResponseEntity<>("Sideshop not found", HttpStatus.NOT_FOUND);
	}
}