package com.inu.hackerton.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ActivityResponse {
    private Long id;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String location;

    public ActivityResponse(Long id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.startTime = (startTime != null) ? startTime.format(formatter) : null;
        this.endTime = (endTime != null) ? endTime.format(formatter) : null;
        this.location = location;
    }
}
