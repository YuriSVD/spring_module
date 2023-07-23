package com.example.spring_module.dao;

import com.example.spring_module.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDAO extends MongoRepository<Car, String> {
    List<Car> findByPower(int power);
    List<Car> findByProducer(String producer);
}
