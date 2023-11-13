package com.manager_api.car.service;

import com.manager_api.car.entitys.typeDocument;
import com.manager_api.car.repository.documentRepository;
import com.manager_api.car.utilities.securityPass;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@NoArgsConstructor
@Transactional
public class utilitiesService {

    private securityPass securityPass = new securityPass();

    @Autowired
    private documentRepository repository;

    public String encrypt(String pass) throws NoSuchAlgorithmException {
        String cadena = securityPass.encrypt(pass);
        System.out.println(cadena);
        return securityPass.encodeToBase64(cadena);
    }

    public List<typeDocument> getDodocuments(){
        List<typeDocument> typeDocuments = null;
        try {
            typeDocuments = repository.findAll();
        } catch (Exception e) {
            // Maneja la excepción si ocurre un error durante la inserción
            e.printStackTrace();
        }

        return typeDocuments;
    }
}
