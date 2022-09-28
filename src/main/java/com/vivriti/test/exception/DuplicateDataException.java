package com.vivriti.test.exception;

public class DuplicateDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DATA_ALREADY_AVAILABLE = "Information already avilable!";

	public DuplicateDataException() {
		super(DATA_ALREADY_AVAILABLE);
	}

	public DuplicateDataException(String messasge) {
		super(messasge);
	}

}
