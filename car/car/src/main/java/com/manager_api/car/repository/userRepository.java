package com.manager_api.car.repository;

import com.manager_api.car.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface userRepository extends JpaRepository<Users,Integer> {

    @Query("SELECT u FROM Users u WHERE u.numero_documento =?1 ")
    Users findByDocument(Long document_number);

    @Query("SELECT u.Id FROM Users u ORDER BY u.Id DESC LIMIT 1")
    Long findLastId();

    @Query("SELECT u FROM Users u WHERE u.email =?1 ")
    Users findUser(String email);

    Optional<Users> findAllById(Long user_id);
}
