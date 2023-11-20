package com.manager_api.car.repository;

import com.manager_api.car.entitys.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface brandsRepository extends JpaRepository<Brands,Integer> {

}
