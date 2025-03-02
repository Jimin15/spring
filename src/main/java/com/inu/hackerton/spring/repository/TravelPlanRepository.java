package com.inu.hackerton.spring.repository;

import com.inu.hackerton.spring.model.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
}
