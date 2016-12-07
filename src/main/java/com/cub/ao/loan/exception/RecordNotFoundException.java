package com.cub.ao.loan.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
