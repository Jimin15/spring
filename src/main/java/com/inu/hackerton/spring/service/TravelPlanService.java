package com.inu.hackerton.spring.service;

import com.inu.hackerton.spring.model.*;
import com.inu.hackerton.spring.repository.TravelPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelPlanService {

    private final TravelPlanRepository travelPlanRepository;


    public TravelPlanResponse createTravelPlan(TravelPlanRequest request) {
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setTitle(request.getTitle());
        travelPlan.setStartDate(request.getStartDate());
        travelPlan.setEndDate(request.getEndDate());

        TravelPlan savedPlan = travelPlanRepository.save(travelPlan);

        return new TravelPlanResponse(
                savedPlan.getId(),
                savedPlan.getTitle(),
                savedPlan.getStartDate(),
                savedPlan.getEndDate(),
                List.of() // 새로 생성된 TravelPlan은 일정이 없으므로 빈 리스트 반환
        );
    }

    // 📌 TravelPlan 조회
    public TravelPlanResponse getTravelPlan(Long id) {
        TravelPlan travelPlan = travelPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel Plan not found"));

        List<DailyScheduleResponse> dailyScheduleResponses = travelPlan.getDailySchedules().stream()
                .map(ds -> {
                    // 🔥 List<ActivityResponse>를 전달하도록 수정
                    List<ActivityResponse> activityResponses = ds.getActivities().stream()
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
                            ds.getId(),
                            ds.getTitle(),
                            ds.getStartTime(),
                            ds.getEndTime(),
                            ds.getLocation(),
                            activityResponses // ✅ 올바르게 List<ActivityResponse> 전달
                    );
                })
                .collect(Collectors.toList());

        return new TravelPlanResponse(
                travelPlan.getId(),
                travelPlan.getTitle(),
                travelPlan.getStartDate(),
                travelPlan.getEndDate(),
                dailyScheduleResponses
        );
    }

    public void deleteTravelPlan(Long id) {
        travelPlanRepository.deleteById(id);
    }
}
