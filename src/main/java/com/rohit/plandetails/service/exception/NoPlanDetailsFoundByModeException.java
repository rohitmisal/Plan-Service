package com.rohit.plandetails.service.exception;

public class NoPlanDetailsFoundByModeException  extends RuntimeException{

	public NoPlanDetailsFoundByModeException() {
		super();
	}

	public NoPlanDetailsFoundByModeException(String msg) {
		super(msg);
	}
	
}
