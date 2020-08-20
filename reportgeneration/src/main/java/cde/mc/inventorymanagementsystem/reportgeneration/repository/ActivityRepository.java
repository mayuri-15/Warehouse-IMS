package cde.mc.inventorymanagementsystem.reportgeneration.repository;

import cde.mc.inventorymanagementsystem.reportgeneration.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,String> {

    @Query(value = "select * from type_of_activity toa where toa.activity_type = ?", nativeQuery = true)
    List<Activity> findByActivityType(String activity_type);

    @Query(value= "select * from type_of_activity toa where toa.vehicle_capacity = ? AND MONTH(create_time_stamp)=?",nativeQuery = true)
    List<Activity> findByCapacityAndMonth(Integer vehicle_capacity, Integer month);

    @Query(value = "select * from type_of_activity toa where toa.activity_type = ? AND YEAR(create_time_stamp) =?", nativeQuery = true)
    List<Activity> findByActivityTypeAndYear(String activityType,Integer Year);
}

