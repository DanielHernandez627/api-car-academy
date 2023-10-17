package com.manager_api.car.controller;

import com.manager_api.car.entitys.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manager_api.car.usecase.userCase;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuarios")
@Api(tags = "Usuarios")

public class UserController {

    @Autowired
    private userCase userCase;

    @ApiOperation(value = "Crear un nuevo usuario")
    @PostMapping
    public boolean crearUsuario(@RequestBody Users usuario) {
        return userCase.create_user(usuario);
    }

    @ApiOperation(value = "Actualizar un usuario")
    @PutMapping
    public boolean actualizarUsuario(@RequestBody Users usuario) {
        return userCase.update_user(usuario);
    }

    @GetMapping("/sumar")
    public Map<String, Object> sumar(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int resultado = num1 + num2;
        Map<String, Object> response = new HashMap<>();
        response.put("message", "La suma es: " + resultado);
        return response;
    }
}
