package com.snapdeal.exception;

import java.sql.SQLException;

public class DatabaseOperationException extends RuntimeException {

	public DatabaseOperationException(String message) {
		super(message);
	}

	public DatabaseOperationException(String string, Exception e) {
		super(string);
	}

}