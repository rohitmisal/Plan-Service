package com.rohit.plandetails.service;

import java.util.List;

import com.rohit.plandetails.model.Plan;

public interface PlanService {

	List<Plan> getAllPlans();

	List<Plan> gePlansByMode(String mode);

	Plan getPlanById(String planId);
	
}
