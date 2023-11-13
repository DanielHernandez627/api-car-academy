package com.manager_api.car.usecase;

import com.manager_api.car.entitys.Session;
import com.manager_api.car.entitys.Users;
import com.manager_api.car.service.userService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class userCase {

    private userService userService;

    public boolean create_user(Users user){
        return userService.create_user_Service(user);
    }

    public boolean update_user(Users user){
        return userService.update_user_Service(user);
    }

    public Users init_user(Session session){
        return  userService.init_session_Service(session);
    }
}
