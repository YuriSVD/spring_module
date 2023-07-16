package com.example.spring_module.services;

import com.example.spring_module.models.Car;
import com.example.spring_module.models.dto.CarDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    void saveCar(CarDTO carDTO);
    ResponseEntity<List<Car>> getAllCars();
    ResponseEntity<Car> getCarById(int id);
    void deleteCar(int id);
    ResponseEntity<List<Car>> getCarsByPower(int value);
    ResponseEntity<List<Car>> getCarsByProducer(String value);
}
