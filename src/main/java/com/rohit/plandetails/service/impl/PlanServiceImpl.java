package com.rohit.plandetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.plandetails.entity.PlanEntity;
import com.rohit.plandetails.mapper.ModelEntityMapper;
import com.rohit.plandetails.model.Plan;
import com.rohit.plandetails.repository.PlanEntityRepository;
import com.rohit.plandetails.service.PlanService;
import com.rohit.plandetails.service.exception.NoPlanDetailsFoundByModeException;
import com.rohit.plandetails.service.exception.NoPlanDetailsFoundException;
import com.rohit.plandetails.service.exception.PlanNotFoundException;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanEntityRepository repository;

	@Autowired
	ModelEntityMapper mapper;

	@Override
	public List<Plan> getAllPlans() {

		List<PlanEntity> lstPlanEntities = repository.findAll();
		List<Plan> lstPlans = new ArrayList<>();
		if (!lstPlanEntities.isEmpty()) {
			lstPlanEntities.forEach(entity -> {
				lstPlans.add(mapper.PlanEntityToPlanMapper(entity));
			});
		} else {

			throw new NoPlanDetailsFoundException("NO Plan Details Found ");
		}

		return lstPlans;
	}

	@Override
	public List<Plan> gePlansByMode(String mode) {
		List<PlanEntity> lstPlanEntities = repository.findByMode(mode);
		List<Plan> lstPlans = new ArrayList<>();

		if (!lstPlanEntities.isEmpty()) {
			lstPlanEntities.forEach(entity -> {
				lstPlans.add(mapper.PlanEntityToPlanMapper(entity));
			});
		} else {

			throw new NoPlanDetailsFoundByModeException(String.format("No Plan details found for given mode %s", mode));
		}

		return lstPlans;
	}

	@Override
	public Plan getPlanById(String planId) {

		Optional<PlanEntity> opt = repository.findById(planId);
		Plan plan = new Plan();
		if (opt.isPresent()) {
			PlanEntity planEntity = opt.get();
			plan = mapper.PlanEntityToPlanMapper(planEntity);
		} else {

			throw new PlanNotFoundException(String.format("NO Plan details are found for PlanId %d", planId));
		}

		return plan;
	}

}
