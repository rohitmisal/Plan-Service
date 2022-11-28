package com.rohit.plandetails.service.exception;

public class NoPlanDetailsFoundException  extends RuntimeException{

	public NoPlanDetailsFoundException() {
		super();
	}
	
	public NoPlanDetailsFoundException(String msg) {
		super(msg);
	}

}
