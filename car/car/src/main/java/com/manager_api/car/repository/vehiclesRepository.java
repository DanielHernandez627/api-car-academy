package com.manager_api.car.repository;

import com.manager_api.car.entitys.Users;
import com.manager_api.car.entitys.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface vehiclesRepository extends JpaRepository<Vehicles,Integer> {

    @Query("SELECT v FROM Vehicles v WHERE v.placa =?1 ")
    Users findByPlate(String placa);

    @Query("SELECT v.Id FROM Vehicles v ORDER BY v.Id DESC LIMIT 1")
    Long findLastId();
}
