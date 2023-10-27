package com.manager_api.car.controller;


import com.manager_api.car.entitys.Authentication;
import com.manager_api.car.entitys.ResponsePass;
import com.manager_api.car.entitys.ResponseUser;
import com.manager_api.car.entitys.Users;
import com.manager_api.car.usecase.utilitiesCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/utilidades")
@Api(tags = "Utilidades")
public class utilitiesController {

    @Autowired
    private utilitiesCase utilitiesCase;

    @ApiOperation(value = "Crear un nuevo usuario")
    @PostMapping
    public ResponseEntity<ResponsePass> crearUsuario(@RequestBody Authentication authentication) throws NoSuchAlgorithmException {
        ResponsePass responsePass = new ResponsePass();

        String result = utilitiesCase.hashPass(authentication.getCadena());

        if (!result.isEmpty()){
            responsePass.setStatus(200);
            responsePass.setControl(result);
        }else {
            responsePass.setStatus(400);
            responsePass.setControl("Fallo");
        }

        return ResponseEntity.status(200).body(responsePass);
    }
}
