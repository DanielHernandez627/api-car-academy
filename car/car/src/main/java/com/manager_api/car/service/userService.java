package com.manager_api.car.service;

import com.manager_api.car.entitys.Session;
import com.manager_api.car.entitys.Users;
import com.manager_api.car.repository.userRepository;
import com.manager_api.car.utilities.securityPass;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class userService {

    private securityPass securityPass = new securityPass();
    @Autowired
    private userRepository userRepository;

    public boolean create_user_Service(Users user){
        Users savedUser = null;
        Long lastId = Long.valueOf(0);
        try {
            var exist = userRepository.findByDocument(user.getNumero_documento());
            if (exist == null){
                lastId = userRepository.findLastId();
                user.setId(lastId+1);
                user.setContrasena(securityPass.encrypt(user.getContrasena()));
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

    public Users init_session_Service(Session session){
        try{
            Users users = userRepository.findUser(session.getEmail());
            String pass = "",passexterior = "";

            if (users.getId() != 0){
                passexterior = users.getContrasena();
                pass = securityPass.encrypt(session.getPassword());
                if (passexterior.equals(pass)){
                    users.setContrasena("");
                    return users;
                }else{
                    return null;
                }
            }

        }catch (Exception e){
            // Maneja la excepción si ocurre un error durante la inserción
            e.printStackTrace();
        }
        return null;
    }

}
