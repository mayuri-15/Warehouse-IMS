package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.controller;

import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service.UserLogService;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service.UserRegService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserRegController.class)
public class VehicleRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRegService userRegService;

    @MockBean
    private UserLogService userLogService;

    @Test
    public void postUserRegistrationTest() throws Exception
    {
        String exampleData="{\"username\":\"surbhi\",\"password\":\"password12\",\"address\":\"flat 1006,pune\",\"drivingLicenseNumber\":\"SR11021994\",\"vehicleNumber\":\"MH-11-9081\",\"vehicleType\":\"Auto\",\"vehicleCapacity\":\"120\"}";
        Mockito.when(userRegService.save(mockUserRegister())).thenReturn(mockUserRegister());
        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/registration/user").accept(MediaType.APPLICATION_JSON).content(exampleData).contentType(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }

  /*  @Test
    public void userValidateTest() throws Exception {
        Mockito.when(userLogService.validate("surbhi","password12")).thenReturn("Login Successfull");
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/login/userlogin?username=surbhi&password=password12").accept(MediaType.ALL);
        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }*/

    private UserRegister mockUserRegister(){
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername("surbhi");
        userRegister.setPassword("password12");
        userRegister.setAddress("flat 1006,pune");
        userRegister.setDrivingLicenseNumber("SR11021994");
        userRegister.setVehicleNumber("MH-11-9081");
        userRegister.setVehicleType("Auto");
        userRegister.setVehicleCapacity(120);
        return userRegister;

    }


}
