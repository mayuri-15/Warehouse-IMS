package cde.mc.inventorymanagementsystem.reportgeneration.service;


import cde.mc.inventorymanagementsystem.reportgeneration.entity.Activity;
import cde.mc.inventorymanagementsystem.reportgeneration.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ActivityRepository activityRepository;


    public List<Activity> reportGenerationByActivity(String activity_type) {
        List<Activity> activity = activityRepository.findByActivityType(activity_type);
        return activity;
    }

    public List<Activity> reportGenerationByCapacityAndMonth(Integer vehicle_capacity, Integer month) {
        List<Activity> activities = activityRepository.findByCapacityAndMonth(vehicle_capacity,month);
        return activities;
    }

    public List<Activity> reportGenerationByActivityAndYear(String activity_type, Integer year) {
        List<Activity> activityList = activityRepository.findByActivityTypeAndYear(activity_type,year);
        return activityList;
    }
}
