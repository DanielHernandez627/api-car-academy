package com.manager_api.car.usecase;


import com.manager_api.car.entitys.Brands;
import com.manager_api.car.entitys.Roles;
import com.manager_api.car.entitys.typeDocument;
import com.manager_api.car.service.utilitiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
@AllArgsConstructor
public class utilitiesCase {

    @Autowired
    private utilitiesService service;

    public String hashPass(String Pass) throws NoSuchAlgorithmException {
        return service.encrypt(Pass);
    }

    public List<typeDocument> typeDocuments(){
        return service.getDodocuments();
    }

    public List<Roles> Roles(){
        return service.getRol();
    }

    public List<Brands> Brands(){
        return service.getBrands();
    }
}
