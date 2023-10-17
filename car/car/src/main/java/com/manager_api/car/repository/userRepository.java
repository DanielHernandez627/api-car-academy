package com.manager_api.car.repository;

import com.manager_api.car.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface userRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findAllById(Long user_id);
}
