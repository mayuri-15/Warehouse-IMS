package cde.mc.inventorymanagementsystem.managetypeofactivity.service;


import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.UserRegister;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.ActivityNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.exception.UserNotFoundException;
import cde.mc.inventorymanagementsystem.managetypeofactivity.repository.ActivityRepository;
import cde.mc.inventorymanagementsystem.managetypeofactivity.constant.ActivityConstant;
import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.Activity;
import cde.mc.inventorymanagementsystem.managetypeofactivity.repository.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ActivityService {


    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRegRepository userRegRepository;

    public Activity saveActivityType(String username,String activity_type) throws UserNotFoundException, ActivityNotFoundException

    {
        Activity activity = new Activity();

        Optional<UserRegister> userRegister = userRegRepository.findById(username);
        if (userRegister.isPresent()) {
            if (activity_type.equalsIgnoreCase(ActivityConstant.activity_loading) || activity_type.equalsIgnoreCase(ActivityConstant.activity_unloading)) {
                LocalDateTime timestamp= LocalDateTime.now();
                activity.setUsername(userRegister.get().getUsername());
                activity.setVehicleCapacity(userRegister.get().getVehicleCapacity());
                activity.setVehicleType(userRegister.get().getVehicleType());
                activity.setVehicleNumber(userRegister.get().getVehicleNumber());
                activity.setActivityType(activity_type);
                activity.setCreateTimeStamp(timestamp);
                activityRepository.save(activity);
                return activity;
            } else {
                throw new ActivityNotFoundException("No such activity found");
            }
        } else {
            throw new UserNotFoundException("No such user found");
        }

    }


}
