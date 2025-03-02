package com.inu.hackerton.spring.service;

import com.inu.hackerton.spring.exception.EntityNotFoundException;
import com.inu.hackerton.spring.model.ActivityRequest;
import com.inu.hackerton.spring.model.ActivityResponse;
import com.inu.hackerton.spring.model.Activity;
import com.inu.hackerton.spring.model.DailySchedule;
import com.inu.hackerton.spring.repository.ActivityRepository;
import com.inu.hackerton.spring.repository.DailyScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final DailyScheduleRepository dailyScheduleRepository;

    // 활동 생성
    // 활동 생성 또는 업데이트
    public ActivityResponse createOrUpdate(ActivityRequest request) {
        // DailySchedule 확인
        DailySchedule dailySchedule = dailyScheduleRepository.findById(request.getDailyScheduleId())
                .orElseThrow(() -> new EntityNotFoundException("Daily Schedule not found for ID: " + request.getDailyScheduleId()));

        Activity activity;
        if (request.getId() != null && request.getId() > 0) {
            // 기존 Activity 업데이트
            activity = activityRepository.findById(request.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Activity not found for ID: " + request.getId()));
        } else {
            // 새 Activity 생성
            activity = new Activity();
        }

        // Activity 필드 설정
        activity.setName(request.getName());
        activity.setDescription(request.getDescription());
        activity.setStartTime(request.getStartTime());
        activity.setEndTime(request.getEndTime());
        activity.setLocation(request.getLocation());
        activity.setDailySchedule(dailySchedule);

        // 저장 후 응답 반환
        Activity savedActivity = activityRepository.save(activity);
        return new ActivityResponse(savedActivity.getId(), savedActivity.getName(), savedActivity.getDescription(), savedActivity.getStartTime(), savedActivity.getEndTime(), savedActivity.getLocation());
    }

    // 특정 활동 조회
    public ActivityResponse getActivity(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        return new ActivityResponse(activity.getId(), activity.getName(), activity.getDescription(), activity.getStartTime(), activity.getEndTime(), activity.getLocation());
    }
}
