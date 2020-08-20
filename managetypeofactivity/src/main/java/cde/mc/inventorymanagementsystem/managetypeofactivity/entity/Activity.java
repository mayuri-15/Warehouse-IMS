package cde.mc.inventorymanagementsystem.managetypeofactivity.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "type_of_activity")
public class Activity {

    @Id
    @Column(unique = true)
    private String username;
    @Column(unique=true)
    private String vehicleNumber;
    private String vehicleType;
    private String activityType;
    private Integer vehicleCapacity;
    private LocalDateTime createTimeStamp;

    public Activity(){}

    public Activity(String username, String vehicleNumber, String vehicleType, String activityType, Integer vehicleCapacity, LocalDateTime createTimeStamp) {
        this.username = username;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.activityType = activityType;
        this.vehicleCapacity = vehicleCapacity;
        this.createTimeStamp = createTimeStamp;
    }
}
