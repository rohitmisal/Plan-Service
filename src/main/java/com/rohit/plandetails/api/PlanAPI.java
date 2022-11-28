package com.rohit.plandetails.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.plandetails.model.Plan;
import com.rohit.plandetails.service.PlanService;

@RestController
@RequestMapping("/api")
public class PlanAPI {

	@Autowired
	PlanService service;

	@GetMapping("plans/all")
	public ResponseEntity<?> getAllPlanDetails() {

		List<Plan> lstPlan = service.getAllPlans();
		return ResponseEntity.status(HttpStatus.OK).body(lstPlan);
	}
	
	@GetMapping("plans/{mode}")
	public ResponseEntity<?> getPlanDetilsByMode(@PathVariable String mode){
		
		List<Plan> plans=service.gePlansByMode(mode);
		return ResponseEntity.status(HttpStatus.OK).body(plans);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<?> getPlanById(@RequestParam String planId){
		Plan p=service.getPlanById(planId);
		return ResponseEntity.status(HttpStatus.OK).body(p);
		
	}
	
}

