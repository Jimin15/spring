package com.inu.hackerton.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ActivityRequest {

    private Long id;  // Activity의 ID 추가

    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Long dailyScheduleId; // Activity가 속한 DailySchedule의 ID
}
