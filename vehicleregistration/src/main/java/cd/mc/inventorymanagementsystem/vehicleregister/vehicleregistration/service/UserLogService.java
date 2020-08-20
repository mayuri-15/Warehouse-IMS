package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service;


import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.exception.UserNameNotFoundException;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.repository.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserLogService {

    @Autowired
    private UserRegRepository userRegRepository;

    public String validate(String username, String password) throws UserNameNotFoundException {

        Optional<UserRegister> userRegister = userRegRepository.findByUserNameAndPassword(username,password);
        if (userRegister.isPresent()) {
           return "Login Successfull";
        } else {
            throw new UserNameNotFoundException("Username: "+username+ " or Password " +password+ " not found in the database");
        }

    }
}
