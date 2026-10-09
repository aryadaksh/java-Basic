package com.exception;

public class CustomerNotFoundException extends RuntimeException
{
	
	public CustomerNotFoundException(String _message) {
		super(_message);
	}

}
