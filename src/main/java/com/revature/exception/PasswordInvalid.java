package com.revature.exception;

public class PasswordInvalid extends RuntimeException {
	
	public PasswordInvalid() {
		super("Password Invalid");
	}
}
