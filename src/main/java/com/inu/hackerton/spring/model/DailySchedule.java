package com.inu.hackerton.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class DailySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    @ManyToOne
    @JoinColumn(name = "travel_plan_id")
    private TravelPlan travelPlan;

    @OneToMany(mappedBy = "dailySchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }
}
