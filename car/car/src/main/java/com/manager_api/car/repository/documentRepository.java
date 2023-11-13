package com.manager_api.car.repository;

import com.manager_api.car.entitys.typeDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface documentRepository extends JpaRepository<typeDocument,Integer> {


}
