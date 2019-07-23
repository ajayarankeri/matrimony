package com.hcl.matrimony.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoTicketException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2318738003576055223L;

	public NoTicketException(String message) {
		super(message);
	}
}
