package com.manager_api.car.usecase;


import com.manager_api.car.service.utilitiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
@AllArgsConstructor
public class utilitiesCase {

    @Autowired
    private utilitiesService service;

    public String hashPass(String Pass) throws NoSuchAlgorithmException {
        return service.encrypt(Pass);
    }

}
