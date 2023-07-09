package com.app.custom_exception;

public class RailNotFoundException extends RuntimeException {
	
	public RailNotFoundException(String mesg) {
		super(mesg);
	}

}
