package com.revature.exception;

public class AuthenticationException extends RuntimeException {
	
	public AuthenticationException() {
		super("Username does not exist");
	}

	public AuthenticationException(String message) {
		super(message);
	}
}
