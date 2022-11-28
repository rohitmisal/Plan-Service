package com.rohit.plandetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_PLANS")
@Data
public class PlanEntity {

	@Id
	@Column(length = 12)
	private String planId;

	@Column(length = 12)
	private String mode;

	@Column(length = 255)
	private String description;
	
	@Column(length = 20)
	private String validity;
	private Double price;

}
