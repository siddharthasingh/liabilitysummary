package com.cub.ao.loan.exception;

public class LoanException extends RuntimeException {
	public LoanException() {
		super();
	}

	public LoanException(String errorMessage) {
		super(errorMessage);
	}

}
