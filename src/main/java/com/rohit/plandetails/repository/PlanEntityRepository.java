package com.rohit.plandetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.plandetails.entity.PlanEntity;

public interface PlanEntityRepository extends JpaRepository<PlanEntity, String> {

	List<PlanEntity> findByMode(String mode);
}
