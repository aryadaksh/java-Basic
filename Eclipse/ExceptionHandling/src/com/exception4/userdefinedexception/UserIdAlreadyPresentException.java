package com.exception4.userdefinedexception;

public class UserIdAlreadyPresentException extends RuntimeException implements AutoCloseable
{
	public UserIdAlreadyPresentException(String message) {
		super(message);
	}

	@Override
	public void close() throws Exception {
		
		
	}

}
