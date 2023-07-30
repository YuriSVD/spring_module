package com.example.spring_module.services;

import com.example.spring_module.models.Car;
import com.example.spring_module.models.dto.CarDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public interface CarService {
    void saveCar(CarDTO carDTO);
    void saveCar(CarDTO carDTO, File file);
    ResponseEntity<List<Car>> getAllCars();
    ResponseEntity<Car> getCarById(String id);
    void deleteCar(String id);
    ResponseEntity<List<Car>> getCarsByPower(int value);
    ResponseEntity<List<Car>> getCarsByProducer(String value);
}
