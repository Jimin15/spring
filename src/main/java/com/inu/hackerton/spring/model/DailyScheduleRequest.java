package com.inu.hackerton.spring.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class DailyScheduleRequest {
    private Long travelPlanId;
    private String title;
    private String startTime;
    private String endTime;
    private String location;

    public LocalDateTime getStartTime() {
        return LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME); // Z 포함 ISO 8601 형식 처리
    }

    public LocalDateTime getEndTime() {
        return LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME); // Z 포함 ISO 8601 형식 처리
    }

}
