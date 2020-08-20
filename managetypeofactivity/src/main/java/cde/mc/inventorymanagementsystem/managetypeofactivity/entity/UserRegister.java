package cde.mc.inventorymanagementsystem.managetypeofactivity.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="user_details")
public class UserRegister {

    @Id
    private String username;
    private String password;
    private String address;
    @Column(unique = true)
    private String drivingLicenseNumber;
    @Column(unique = true)
    private String vehicleNumber;
    private String vehicleType;
    private Integer vehicleCapacity;

    public UserRegister(){}

    public UserRegister(String username, String password, String address, String drivingLicenseNumber, String vehicleNumber, String vehicleType, Integer vehicleCapacity) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleCapacity = vehicleCapacity;
    }
}