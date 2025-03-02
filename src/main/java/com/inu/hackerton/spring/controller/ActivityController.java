package com.inu.hackerton.spring.controller;


import com.inu.hackerton.spring.exception.EntityNotFoundException;
import com.inu.hackerton.spring.model.ActivityRequest;
import com.inu.hackerton.spring.model.ActivityResponse;
import com.inu.hackerton.spring.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    // 활동 생성 또는 업데이트
    @PostMapping
    public ActivityResponse createOrUpdateActivity(@RequestBody ActivityRequest request) {
        return activityService.createOrUpdate(request);
    }

    // 특정 활동 조회
    @GetMapping("/{id}")
    public ActivityResponse getActivity(@PathVariable Long id) {
        return activityService.getActivity(id);
    }

    // 예외 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

