package com.inu.hackerton.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TravelPlanRequest {
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;  // LocalDate로 변경

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;    // LocalDate로 변경
}
