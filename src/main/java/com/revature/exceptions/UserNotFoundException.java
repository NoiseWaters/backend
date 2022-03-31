package com.revature.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{
	
	// right click -> source -> generate Constructors from SuperClass
	public UserNotFoundException(String message) {
		super(message);
	}

}