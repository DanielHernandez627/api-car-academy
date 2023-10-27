package com.manager_api.car.service;

import com.manager_api.car.utilities.securityPass;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@NoArgsConstructor
@Transactional
public class utilitiesService {

    private securityPass securityPass = new securityPass();

    public String encrypt(String pass) throws NoSuchAlgorithmException {
        String cadena = securityPass.encrypt(pass);
        System.out.println(cadena);
        return securityPass.encodeToBase64(cadena);
    }


}
