package cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.repository;


import cd.mc.inventorymanagementsystem.vehicleregister.vehicleregistration.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegRepository extends JpaRepository<UserRegister,String> {

    @Query(value = "select * from user_details where username = ? and password = ?",nativeQuery = true)
    public Optional<UserRegister> findByUserNameAndPassword(String username, String password);
}
