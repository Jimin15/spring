package com.inu.hackerton.spring.controller;

import com.inu.hackerton.spring.model.DailyScheduleRequest;
import com.inu.hackerton.spring.model.DailyScheduleResponse;
import com.inu.hackerton.spring.service.DailyScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailyschedules")
@RequiredArgsConstructor
public class DailyScheduleController {

    private final DailyScheduleService dailyScheduleService;

    // 일일 일정 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DailyScheduleResponse createDailySchedule(@RequestBody DailyScheduleRequest request) {
        return dailyScheduleService.createDailySchedule(request);
    }

    // 일일 일정 조회
    @GetMapping("/{id}")
    public DailyScheduleResponse getDailySchedule(@PathVariable Long id) {
        return dailyScheduleService.getDailySchedule(id);
    }
}
