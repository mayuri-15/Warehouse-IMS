package cde.mc.inventorymanagementsystem.managetypeofactivity.service;

import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.Activity;
import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.UserRegister;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.ActivityNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.UserNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.repository.ActivityRepository;
import cde.mc.inventorymanagementsystem.managetypeofactivity.repository.UserRegRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManageActivityServiceTest {
    @Autowired
    private ActivityService activityService;

    @MockBean
    private ActivityRepository activityRepository;

    @MockBean
    private UserRegRepository userRegRepository;

    public UserRegister getRegisteredUser(){
        UserRegister userRegister = new UserRegister("mayuri","password123","flat 16,pune","MR12345","MH-15-1997","Truck",1000);
        return userRegister;
    }

    public Activity getActivityWithLoading(){
        Activity activity = new Activity();
        LocalDateTime localDateTime = LocalDateTime.now();
        activity.setUsername(getRegisteredUser().getUsername());
        activity.setVehicleNumber(getRegisteredUser().getVehicleNumber());
        activity.setVehicleType(getRegisteredUser().getVehicleType());
        activity.setActivityType("loading");
        activity.setVehicleCapacity(getRegisteredUser().getVehicleCapacity());
        activity.setCreateTimeStamp(localDateTime);
        return activity;
    }
    public Activity getActivityWithUnloading(){
        Activity activity = new Activity();
        LocalDateTime localDateTime = LocalDateTime.now();
        activity.setUsername(getRegisteredUser().getUsername());
        activity.setVehicleNumber(getRegisteredUser().getVehicleNumber());
        activity.setVehicleType(getRegisteredUser().getVehicleType());
        activity.setActivityType("unloading");
        activity.setVehicleCapacity(getRegisteredUser().getVehicleCapacity());
        activity.setCreateTimeStamp(localDateTime);
        return activity;
    }

    @Test
    public void saveActivityLoadingTest() throws ActivityNotFoundException, UserNotFoundException {
        when(userRegRepository.findById("mayuri")).thenReturn(java.util.Optional.ofNullable(getRegisteredUser()));
        Activity response = activityService.saveActivityType("mayuri","loading");
        assertNotNull(response);
        assertEquals("mayuri", response.getUsername());
        assertEquals("Truck", response.getVehicleType());
        assertEquals("loading",response.getActivityType());
    }

    @Test
    public void saveActivityUnloadingTest() throws ActivityNotFoundException, UserNotFoundException {
        when(userRegRepository.findById("mayuri")).thenReturn(java.util.Optional.ofNullable(getRegisteredUser()));
        Activity response = activityService.saveActivityType("mayuri","unloading");
        assertEquals("mayuri",response.getUsername());
        assertEquals("Truck",response.getVehicleType());
        assertEquals("unloading",response.getActivityType());
    }

    @Test(expected = UserNotFoundException.class)
    public void validateWrongUsernameTest() throws UserNotFoundException, ActivityNotFoundException {
        activityService.saveActivityType("harsh", "loading");
        when(userRegRepository.findById("harsh")).
                thenThrow(new UserNotFoundException(""));
    }
    @Test(expected = ActivityNotFoundException.class)
    public void validateWrongActivityTest() throws UserNotFoundException, ActivityNotFoundException {
        when(userRegRepository.findById("mayuri")).thenReturn(java.util.Optional.ofNullable(getRegisteredUser()));
        activityService.saveActivityType("mayuri", "manufacturing");
        when(userRegRepository.findById("mayuri")).
                thenThrow(new ActivityNotFoundException(""));

    }
}
