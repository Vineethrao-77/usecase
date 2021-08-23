package com.learn.training.FundTransfer.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnableTOTransferFundException extends Exception {

	public UnableTOTransferFundException(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	
}
