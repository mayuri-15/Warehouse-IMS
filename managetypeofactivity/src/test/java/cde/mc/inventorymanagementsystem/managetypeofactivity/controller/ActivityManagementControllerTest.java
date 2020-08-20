package cde.mc.inventorymanagementsystem.managetypeofactivity.controller;

import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.Activity;
import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.UserRegister;
import cde.mc.inventorymanagementsystem.managetypeofactivity.service.ActivityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ActivityController.class)
public class ActivityManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ActivityService activityService;


   @Test
    public void postUserActivityTest() throws Exception{
       Mockito.when(activityService.saveActivityType("mayuri","loading")).thenReturn(getActivityWithLoading());
       RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/managetypeofactivities/useractivity?username=mayuri&activity_type=loading")
               .accept(MediaType.ALL);
       MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
       MockHttpServletResponse response = mvcResult.getResponse();
       Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
   }
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

}
