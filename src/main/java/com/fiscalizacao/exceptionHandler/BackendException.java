package com.fiscalizacao.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BackendException extends RuntimeException{
	public BackendException(String message) {
		super(message);
	}
	
	public BackendException(String message, Throwable causa) {
		super(message, causa);
	}
}
