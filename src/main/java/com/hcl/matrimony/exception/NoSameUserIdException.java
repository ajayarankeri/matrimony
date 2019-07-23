package com.hcl.matrimony.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoSameUserIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859805675329240328L;

	public NoSameUserIdException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
