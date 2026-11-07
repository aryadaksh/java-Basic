package com.snapdeal.exception;

public class InvalidQuantityException extends RuntimeException
{

	public InvalidQuantityException(String message) {
		super(message);
	}
}