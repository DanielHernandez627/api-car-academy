package com.manager_api.car.controller;


import com.manager_api.car.entitys.*;
import com.manager_api.car.usecase.utilitiesCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/utilidades")
@Api(tags = "Utilidades")
@CrossOrigin(origins = "http://127.0.0.1:5500")
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

    @ApiOperation(value = "Consultar documentos")
    @GetMapping(value = "/getDocumentos")
    public ResponseTypeDocument getDocumentos(){
        ResponseTypeDocument responseTypeDocument = new ResponseTypeDocument();

        List<typeDocument> typeDocuments = utilitiesCase.typeDocuments();

        if (typeDocuments != null){
            responseTypeDocument.setStatus(200);
            responseTypeDocument.setMessage("Exito");
            responseTypeDocument.setTypeDocument(typeDocuments);
        }else{
            responseTypeDocument.setStatus(400);
            responseTypeDocument.setMessage("Fallo");
            responseTypeDocument.setTypeDocument(null);
        }

        return responseTypeDocument;
    }

    @ApiOperation(value = "Consultar Roles")
    @GetMapping(value = "/getRoles")
    public ResponseRoles getRoles(){
        ResponseRoles responseRoles = new ResponseRoles();

        List<Roles> rolesList = utilitiesCase.Roles();

        if (rolesList != null){
            responseRoles.setStatus(200);
            responseRoles.setMessage("Exito");
            responseRoles.setRolesList(rolesList);
        }else{
            responseRoles.setStatus(400);
            responseRoles.setMessage("Fallo");
            responseRoles.setRolesList(null);
        }

        return responseRoles;
    }

    @ApiOperation(value = "Consultar documentos")
    @GetMapping(value = "/getMarcas")
    public ResponseBrands getMarcas(){
        ResponseBrands responseBrands = new ResponseBrands();

        List<Brands> brandsList = utilitiesCase.Brands();

        if (brandsList != null){
            responseBrands.setStatus(200);
            responseBrands.setMessage("Exito");
            responseBrands.setBrandsList(brandsList);
        }else{
            responseBrands.setStatus(400);
            responseBrands.setMessage("Fallo");
            responseBrands.setBrandsList(null);
        }

        return responseBrands;
    }
}
