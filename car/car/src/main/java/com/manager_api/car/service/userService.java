package com.manager_api.car.service;

import com.manager_api.car.entitys.Users;
import com.manager_api.car.repository.userRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class userService {

    @Autowired
    private userRepository userRepository;

    public boolean create_user_Service(Users user){
        Users savedUser = null;
        try {
            var exist = userRepository.findByDocument(user.getNumero_documento());
            if (exist == null){
                savedUser = userRepository.save(user);
                return savedUser != null && savedUser.getId() != null;
            }else{
                return false;
            }
        } catch (Exception e) {
            // Maneja la excepción si ocurre un error durante la inserción
            e.printStackTrace();
            return false;
        }
    }

    public boolean update_user_Service(Users user){
        try {
            Long user_id = user.getId();
            Optional<Users> exist = userRepository.findAllById(user_id);
            if (!exist.isEmpty()){
                exist.get().setNombres(user.getNombres());
                exist.get().setApellidos(user.getApellidos());
                exist.get().setDireccion(user.getDireccion());
                exist.get().setEmail(user.getEmail());

                Users savedUser = userRepository.save(user);
                return savedUser != null && savedUser.getId() != null;
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (Exception e) {
            // Maneja la excepción si ocurre un error durante la inserción
            e.printStackTrace();
            return false;
        }
    }

}
