package com.inu.hackerton.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class TravelPlanResponse {
    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DailyScheduleResponse> dailySchedules;
}