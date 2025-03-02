package com.inu.hackerton.spring.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public class DailyScheduleResponse {
    private Long id;
    private String title;
    private String startTime;
    private String endTime;
    private String location;
    private List<ActivityResponse> activities = List.of(); // 빈 리스트로 초기화

    public DailyScheduleResponse(Long id, String title, LocalDateTime startTime, LocalDateTime endTime, String location, List<ActivityResponse> activities) {
        this.id = id;
        this.title = title;
        this.startTime = startTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.endTime = endTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.location = location;
        this.activities = activities != null ? activities : List.of(); // null 처리
    }
}
