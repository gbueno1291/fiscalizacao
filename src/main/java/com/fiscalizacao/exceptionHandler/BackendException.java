package com.fiscalizacao.exceptionHandler;

public class BackendException extends RuntimeException{
	public BackendException(String message) {
		super(message);
	}
	
	public BackendException(String message, Throwable causa) {
		super(message, causa);
	}
}
