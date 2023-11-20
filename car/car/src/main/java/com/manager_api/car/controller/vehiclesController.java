package com.manager_api.car.controller;

import com.manager_api.car.entitys.ResponseUser;
import com.manager_api.car.entitys.ResponseVehicles;
import com.manager_api.car.entitys.Users;
import com.manager_api.car.entitys.Vehicles;
import com.manager_api.car.usecase.vehiclesCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehiculos")
@Api(tags = "Vehiculos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class vehiclesController {

    @Autowired
    private vehiclesCase vehiclesCase;


    @ApiOperation(value = "Crear un nuevo vehiculo")
    @PostMapping
    public ResponseEntity<ResponseVehicles> crearVehiculo(@RequestBody Vehicles vehicles) {
        ResponseVehicles responseVehicles = new ResponseVehicles();

        if (vehiclesCase.create_vehicle(vehicles)){
            responseVehicles.setStatus(200);
            responseVehicles.setMessage("Exito");
        }else {
            responseVehicles.setStatus(400);
            responseVehicles.setMessage("Fallo");
        }
        return ResponseEntity.status(200).body(responseVehicles);
    }

}
