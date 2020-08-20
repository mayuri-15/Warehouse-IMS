package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name="user_details")
public class UserRegister {

    @Id
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "address is required")
    private String address;
    @Column(unique=true)
    @NotBlank(message = "driving license number is required")
    private String drivingLicenseNumber;
    @Column(unique=true)
    @NotBlank(message = "vehicle number is required")
    private String vehicleNumber;
    @NotBlank(message = "vehicle type is required")
    private String vehicleType;
    @NotNull(message = "vehicle capacity is required")
    private Integer vehicleCapacity;

    public UserRegister(){
    }

    public UserRegister(@NotBlank String username, @NotBlank String password, @NotBlank String address, @NotBlank String drivingLicenseNumber, @NotBlank String vehicleNumber, @NotBlank String vehicleType, @NotNull Integer vehicleCapacity) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleCapacity = vehicleCapacity;
    }
}

