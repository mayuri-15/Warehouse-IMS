package cde.mc.inventorymanagementsystem.managetypeofactivity.controller;


import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.Activity;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.ActivityNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.UserNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/managetypeofactivities")
public class ActivityController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @Autowired
    private ActivityService activityService;

    @PostMapping("/useractivity")
    public Activity saveActivityType(@RequestParam String username, @RequestParam String activity_type) throws ActivityNotFoundException, UserNotFoundException {
        return activityService.saveActivityType(username, activity_type);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> userNotFoundException(UserNotFoundException  ex)
    {
        Map<String,String> errors= new HashMap<>();
        errors.put("message",ex.getMessage());
        errors.put("status","404");
        return errors;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ActivityNotFoundException.class)
    public Map<String,String> activityNotFound(ActivityNotFoundException  ex)
    {
        Map<String,String> errors= new HashMap<>();
        errors.put("message",ex.getMessage());
        errors.put("status","404 ");
        return errors;
    }

    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }
}
