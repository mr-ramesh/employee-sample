package com.vivriti.test.exception;

public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DATA_NOT_AVAILABLE = "Information which you requested not avilable!";

	public DataNotFoundException() {
		super(DATA_NOT_AVAILABLE);
	}

	public DataNotFoundException(String messasge) {
		super(messasge);
	}

}
