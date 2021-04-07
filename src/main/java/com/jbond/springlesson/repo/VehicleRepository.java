package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findVehicleByVehName(@Param("vehName") String vehName);
}
