package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service;

import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.exception.UserNameNotFoundException;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.repository.UserRegRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleRegistrationServiceTest {

    @Autowired
    private UserRegService userRegService;

    @Autowired
    private UserLogService userLogService;

    @MockBean
    private UserRegRepository userRegRepository;

    private UserRegister mockuserRegister() {
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

    @Test
    public void registerUserAccountTest(){
        when(userRegRepository.save(mockuserRegister())).thenReturn(mockuserRegister());
        assertEquals(mockuserRegister(), userRegService.save(mockuserRegister()));

    }

    @Test
    public void validateUsernameTest() throws UserNameNotFoundException {
        when(userRegRepository.findByUserNameAndPassword("surbhi","password12")).thenReturn(Optional.of(mockuserRegister()));
        assertEquals("Login Successfull",userLogService.validate("surbhi","password12"));

    }
    @Test(expected=UserNameNotFoundException.class)
    public void validateWrongUsernameTest()  throws UserNameNotFoundException{
        userLogService.validate("mayuri","password12");
        when(userRegRepository.findByUserNameAndPassword("mayuri","password12")).
                thenThrow(new UserNameNotFoundException(""));

    }

}
