package com.manager_api.car.service;

import com.manager_api.car.entitys.Vehicles;
import com.manager_api.car.repository.vehiclesRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Transactional
public class vehiclesService {

    @Autowired
    private vehiclesRepository vehiclesRepository;

    public boolean create_vehicle_Service(Vehicles vehicles){
        Vehicles savedVehicles = null;
        Long lastId = Long.valueOf(0);
        try {
            var exist = vehiclesRepository.findByPlate(vehicles.getPlaca());
            if (exist == null){
                if (vehiclesRepository.findLastId() == null){
                    lastId = Long.valueOf(1);
                }else{
                    lastId = vehiclesRepository.findLastId();
                }

                vehicles.setId(lastId+1);
                savedVehicles = vehiclesRepository.save(vehicles);
                return savedVehicles != null && savedVehicles.getId() != null;
            }else{
                return false;
            }
        } catch (Exception e) {
            // Maneja la excepción si ocurre un error durante la inserción
            e.printStackTrace();
            return false;
        }
    }

}
