package com.rohit.plandetails.service.exception;

public class PlanNotFoundException extends RuntimeException{

	public PlanNotFoundException() {
		super();
	}
	public PlanNotFoundException(String msg) {
		super(msg);
	}

	
}
