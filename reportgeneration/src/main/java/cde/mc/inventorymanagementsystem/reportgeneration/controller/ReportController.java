package cde.mc.inventorymanagementsystem.reportgeneration.controller;


import cde.mc.inventorymanagementsystem.reportgeneration.entity.Activity;
import cde.mc.inventorymanagementsystem.reportgeneration.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generatereport")
public class ReportController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @Autowired
    private ReportService reportService;

    @GetMapping("/byActivity")
    public List<Activity> reportGenerationByActivity(@RequestParam String activity_type){
        List<Activity> activity = reportService.reportGenerationByActivity(activity_type);
        return activity;
    }

    @GetMapping("/bycapacityandmonth")
    public List<Activity> reportGenerationByCapacityAndMonth(@RequestParam Integer vehicle_capacity,@RequestParam Integer month){
        List<Activity> activities = reportService.reportGenerationByCapacityAndMonth(vehicle_capacity,month);
        return activities;
    }

    @GetMapping("/byactivityandyear")
    public List<Activity> reportGenerationByActivityAndYear(@RequestParam String activity_type,@RequestParam Integer year){
        List<Activity> activityList = reportService.reportGenerationByActivityAndYear(activity_type,year);
        return activityList;
    }

    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }

}
