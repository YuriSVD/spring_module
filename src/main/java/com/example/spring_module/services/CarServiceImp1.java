package com.example.spring_module.services;

import com.example.spring_module.dao.CarDAO;
import com.example.spring_module.models.Car;
import com.example.spring_module.models.dto.CarDTO;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("one")
@AllArgsConstructor
public class CarServiceImp1 implements CarService {
    private CarDAO carDAO;
    public void saveCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getModel(), carDTO.getProducer(), carDTO.getPower());
        carDAO.save(car);
    }
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Car> getCarById(String id) {
        return new ResponseEntity<>(carDAO.findById(id).get(), HttpStatus.OK);
    }
    public void deleteCar(String id) {
            carDAO.deleteById(id);
    }
    public ResponseEntity<List<Car>> getCarsByPower(int value) {
        return new ResponseEntity<>(carDAO.findByPower(value), HttpStatus.OK);
    }
    public ResponseEntity<List<Car>> getCarsByProducer(String value) {
        return new ResponseEntity<>(carDAO.findByProducer(value), HttpStatus.OK);
    }
}
