package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.controller;


import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.exception.UserNameNotFoundException;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class UserLogController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @Autowired
    private UserLogService userLogService;

    @GetMapping("/userlogin")
    public String loginUser(@Valid @RequestParam String username, @RequestParam String password) throws UserNameNotFoundException {
        String message = userLogService.validate(username,password);
        return message;
    }

    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }

}