package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.service;

import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.repository.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegService {

    @Autowired
    private UserRegRepository userRegRepository;

    public UserRegister save(UserRegister userRegister) {
       return userRegRepository.save(userRegister);
    }
}
