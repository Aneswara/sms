package com.sms.exception;

public class SmsDaoException extends Exception {

	public SmsDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SmsDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SmsDaoException(String message) {
		super(message);
	}

	public SmsDaoException(Throwable cause) {
		super(cause);
	}

}
