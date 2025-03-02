package com.inu.hackerton.spring.controller;

import com.inu.hackerton.spring.model.*;
import com.inu.hackerton.spring.service.DailyScheduleService;
import com.inu.hackerton.spring.service.TravelPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travelplans")
@RequiredArgsConstructor
public class TravelPlanController {

    private final TravelPlanService travelPlanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelPlanResponse createTravelPlan(@RequestBody TravelPlanRequest request) {
        return travelPlanService.createTravelPlan(request);
    }

    @GetMapping("/{id}")
    public TravelPlanResponse getTravelPlan(@PathVariable Long id) {
        return travelPlanService.getTravelPlan(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTravelPlan(@PathVariable Long id) {
        travelPlanService.deleteTravelPlan(id);
    }
}