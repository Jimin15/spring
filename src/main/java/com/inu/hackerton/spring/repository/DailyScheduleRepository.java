package com.inu.hackerton.spring.repository;

import com.inu.hackerton.spring.model.DailySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyScheduleRepository extends JpaRepository<DailySchedule, Long> {
}
