package com.manager_api.car.controller;

import com.manager_api.car.entitys.ResponseUser;
import com.manager_api.car.entitys.Session;
import com.manager_api.car.entitys.SessionResponse;
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
    public ResponseEntity<ResponseUser> crearUsuario(@RequestBody Users usuario) {
        ResponseUser responseUser = new ResponseUser();

        if (userCase.create_user(usuario)){
            responseUser.setStatus(200);
            responseUser.setMessage("Exito");
        }else {
            responseUser.setStatus(400);
            responseUser.setMessage("Fallo");
        }
        return ResponseEntity.status(200).body(responseUser);
    }

    @ApiOperation(value = "Inicio de sesion")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(value = "/initsession")
    public ResponseEntity<SessionResponse> initSession(@RequestBody Session session){
        SessionResponse sessionResponse = new SessionResponse();
        Users respuesta = userCase.init_user(session);
        if (respuesta != null){
            sessionResponse.setStatus(200);
            sessionResponse.setMessage("Exito");
            respuesta.setContrasena("");
            sessionResponse.setUsers(respuesta);
        }else{
            sessionResponse.setStatus(400);
            sessionResponse.setMessage("Fallo");
        }

        return ResponseEntity.status(200).body(sessionResponse);
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
