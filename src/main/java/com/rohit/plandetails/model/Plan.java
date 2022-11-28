package com.rohit.plandetails.model;

import lombok.Data;

@Data
public class Plan {

	private String planId;
	private String mode;
	private String description;
	private String validity;
	private Double price;

}
