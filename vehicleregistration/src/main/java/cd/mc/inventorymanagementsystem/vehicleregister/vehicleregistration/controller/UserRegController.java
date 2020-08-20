package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.controller;


import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service.UserRegService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@Api(value = "UserRegistrationControllerApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRegController {

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;


    @Autowired
    private UserRegService userRegService;

    @PostMapping(value = "/user")
    @ApiOperation("Registers User with his details")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = UserRegister.class)})
    public ResponseEntity<UserRegister> registerUserAccount(@Valid @RequestBody UserRegister userRegister) {

            return new ResponseEntity<>(userRegService.save(userRegister), HttpStatus.CREATED);

    }

    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }
}