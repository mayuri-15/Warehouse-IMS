package cde.mc.inventorymanagementsystem.managetypeofactivity.repository;

import cde.mc.inventorymanagementsystem.managetypeofactivity.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends JpaRepository<UserRegister,String> {

}
