package cde.mc.inventorymanagementsystem.reportgeneration.controller;

import cde.mc.inventorymanagementsystem.reportgeneration.entity.Activity;
import cde.mc.inventorymanagementsystem.reportgeneration.service.ReportService;
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
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReportController.class)
public class ReportGenerationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReportService reportService;


    @Test
    public void getActivityReportTest() throws Exception
    {
        Mockito.when(reportService.reportGenerationByActivity("loading")).thenReturn(activities());
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/generatereport/byActivity?activity_type=loading").accept(MediaType.ALL);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    @Test
    public void getActivityyearwisereportTest() throws Exception
    {
        Mockito.when(reportService.reportGenerationByActivityAndYear("loading",2020)).thenReturn(activities());
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/generatereport/byactivityandyear?activity_type=loading&year=2020").accept(MediaType.ALL);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    @Test
    public void getCapacitymonthwisereport() throws Exception
    {
        Mockito.when(reportService.reportGenerationByCapacityAndMonth(1000,8)).thenReturn(activities());
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/generatereport/bycapacityandmonth?vehicle_capacity=1000&month=8").accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    private List<Activity> activities(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Activity activity = new Activity();
        ArrayList<Activity> list=new ArrayList<Activity>();
        activity.setActivityType("loading");
        activity.setUsername("dummy");
        activity.setVehicleCapacity(1000);
        activity.setVehicleNumber("abc123");
        activity.setVehicleType("hemitruck");
        activity.setCreateTimeStamp(localDateTime);
        list.add(activity);
        return list;
    }


}
