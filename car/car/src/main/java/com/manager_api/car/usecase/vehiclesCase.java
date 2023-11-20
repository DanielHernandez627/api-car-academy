package com.manager_api.car.usecase;

import com.manager_api.car.entitys.Users;
import com.manager_api.car.entitys.Vehicles;
import com.manager_api.car.service.vehiclesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class vehiclesCase {

    private vehiclesService vehiclesServices;

    public boolean create_vehicle(Vehicles vehicles){
        return vehiclesServices.create_vehicle_Service(vehicles);
    }

}
