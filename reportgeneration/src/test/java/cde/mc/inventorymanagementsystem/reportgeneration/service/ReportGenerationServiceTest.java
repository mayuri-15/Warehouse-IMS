package cde.mc.inventorymanagementsystem.reportgeneration.service;


import cde.mc.inventorymanagementsystem.reportgeneration.entity.Activity;
import cde.mc.inventorymanagementsystem.reportgeneration.repository.ActivityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReportGenerationServiceTest {
    @Autowired
    private ReportService reportService;

    @MockBean
    private ActivityRepository activityRepository;

    private List<Activity> mockLoadingActivity(){
        LocalDateTime localDateTime= LocalDateTime.now();
        List<Activity> activities = new ArrayList<>();
        Activity activity = new Activity("mayuri","MH-10-9976","Truck","loading",1000,localDateTime);
        Activity activity1 = new Activity("pratik","MP-08-9977","Truck","loading",1000,localDateTime);
        activities.add(0,activity);
        activities.add(1,activity1);
        return activities;
    }
    private List<Activity> mockUnloadingActivity(){
        LocalDateTime localDateTime= LocalDateTime.now();
        List<Activity> activities = new ArrayList<>();
        Activity activity = new Activity("sneha","KN-18-9978","Auto","unloading",100,localDateTime);
        Activity activity1 = new Activity("manjari","MP-02-9979","Auto","unloading",100,localDateTime);
        activities.add(0,activity);
        activities.add(1,activity1);
        return activities;
    }
    @Test
    public void reportByLoadingActivityTest(){
        List<Activity> activities = mockLoadingActivity();
        when(activityRepository.findByActivityType("loading")).thenReturn((activities));
        assertEquals(activities,reportService.reportGenerationByActivity("loading"));
    }
    @Test
    public void reportByUnloadingActivityTest(){
        List<Activity> activities = mockUnloadingActivity();
        when(activityRepository.findByActivityType("unloading")).thenReturn((activities));
        assertEquals(activities,reportService.reportGenerationByActivity("unloading"));
    }
    @Test
    public void reportByCapacityAndMonthTest(){
        List<Activity> activities = mockLoadingActivity();
        when(activityRepository.findByCapacityAndMonth(1000,8)).thenReturn(activities);
        assertEquals(activities,reportService.reportGenerationByCapacityAndMonth(1000,8));
    }
    @Test
    public void reportByLoadingActivityAndYearTest(){
        List<Activity> activities = mockLoadingActivity();
        when(activityRepository.findByActivityTypeAndYear("loading",2020)).thenReturn(activities);
        assertEquals(activities,reportService.reportGenerationByActivityAndYear("loading",2020));
    }
    @Test
    public void reportByUnloadingActivityAndYearTest(){
        List<Activity> activities = mockUnloadingActivity();
        when(activityRepository.findByActivityTypeAndYear("unloading",2020)).thenReturn(activities);
        assertEquals(activities,reportService.reportGenerationByActivityAndYear("unloading",2020));
    }
}
