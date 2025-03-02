package com.inu.hackerton.spring.service;

import com.inu.hackerton.spring.model.ActivityResponse;
import com.inu.hackerton.spring.model.DailyScheduleRequest;
import com.inu.hackerton.spring.model.DailyScheduleResponse;
import com.inu.hackerton.spring.model.DailySchedule;
import com.inu.hackerton.spring.model.TravelPlan;
import com.inu.hackerton.spring.repository.DailyScheduleRepository;
import com.inu.hackerton.spring.repository.TravelPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyScheduleService {

    private final TravelPlanRepository travelPlanRepository;
    private final DailyScheduleRepository dailyScheduleRepository;

    // DailySchedule 생성
    public DailyScheduleResponse createDailySchedule(DailyScheduleRequest request) {
        // TravelPlan 존재 여부 확인
        TravelPlan travelPlan = travelPlanRepository.findById(request.getTravelPlanId())
                .orElseThrow(() -> new RuntimeException("Travel Plan with ID " + request.getTravelPlanId() + " not found"));

        DailySchedule dailySchedule = new DailySchedule();
        dailySchedule.setTitle(request.getTitle());
        dailySchedule.setStartTime(request.getStartTime());
        dailySchedule.setEndTime(request.getEndTime());
        dailySchedule.setLocation(request.getLocation());
        dailySchedule.setTravelPlan(travelPlan);

        DailySchedule savedSchedule = dailyScheduleRepository.save(dailySchedule);

        List<ActivityResponse> activityResponses = (savedSchedule.getActivities() == null)
                ? List.of()  // ✅ null이 아닌 빈 리스트 반환
                : savedSchedule.getActivities().stream()
                .map(activity -> new ActivityResponse(
                        activity.getId(),
                        activity.getName(),
                        activity.getDescription(),
                        activity.getStartTime(),
                        activity.getEndTime(),
                        activity.getLocation()
                ))
                .collect(Collectors.toList());

        // 빈 배열로 확실하게 반환되도록 처리
        return new DailyScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getStartTime(),
                savedSchedule.getEndTime(),
                savedSchedule.getLocation(),
                activityResponses // 빈 배열 처리
        );
    }


    // DailySchedule 조회
    public DailyScheduleResponse getDailySchedule(Long id) {
        DailySchedule dailySchedule = dailyScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Daily Schedule not found"));

        List<ActivityResponse> activityResponses = dailySchedule.getActivities().stream()
                .map(activity -> new ActivityResponse(
                        activity.getId(),
                        activity.getName(),
                        activity.getDescription(),
                        activity.getStartTime(),
                        activity.getEndTime(),
                        activity.getLocation()
                ))
                .collect(Collectors.toList());

        return new DailyScheduleResponse(
                dailySchedule.getId(),
                dailySchedule.getTitle(),
                dailySchedule.getStartTime(),
                dailySchedule.getEndTime(),
                dailySchedule.getLocation(),
                activityResponses
        );
    }
}

