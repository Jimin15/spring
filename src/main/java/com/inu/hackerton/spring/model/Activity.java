package com.inu.hackerton.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    @ManyToOne
    @JoinColumn(name = "daily_schedule_id")
    private DailySchedule dailySchedule;
}
