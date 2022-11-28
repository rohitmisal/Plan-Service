package com.rohit.plandetails.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.rohit.plandetails.entity.PlanEntity;
import com.rohit.plandetails.model.Plan;

@Component
public class ModelEntityMapper {

	public PlanEntity PlanTOPlanEntityMapper(Plan plan) {
		
		PlanEntity planEntity =new PlanEntity();
		BeanUtils.copyProperties(plan, planEntity);
		return planEntity;
		
	}
	
	public Plan PlanEntityToPlanMapper(PlanEntity planEntity) {
		Plan plan=new Plan();
		BeanUtils.copyProperties(planEntity, plan);
		return plan;
	}
}
