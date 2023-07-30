package com.example.spring_module.controllers;

import com.example.spring_module.models.Car;
import com.example.spring_module.models.dto.CarDTO;
import com.example.spring_module.models.views.Views;
import com.example.spring_module.services.CarService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {
    private CarService carService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@RequestBody CarDTO carDTO) {
        carService.saveCar(carDTO);
    }
    @GetMapping()
    @JsonView(Views.Level3.class)
    public ResponseEntity<List<Car>> getAllCars() {
        return carService.getAllCars();
    }
    @GetMapping("/{id}")
    @JsonView(Views.Level1.class)
    public ResponseEntity<Car> getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteCarById(@PathVariable String id) {
        carService.deleteCar(id);
    }
    @GetMapping("/power/{value}")
    @JsonView(Views.Level2.class)
    public ResponseEntity<List<Car>> getAllCarsByPower(@PathVariable int value) {
        return carService.getCarsByPower(value);
    }
    @GetMapping("producer/{value}")
    @JsonView(Views.Level2.class)
    public ResponseEntity<List<Car>> getCarsByProducer(@PathVariable String value) {
        return carService.getCarsByProducer(value);
    }
    @SneakyThrows
    @PostMapping("/savecarwithpic")
    public void saveCarWithPic(@RequestParam("picture") MultipartFile picture,
                               @RequestParam("model") String model,
                               @RequestParam("producer") String producer,
                               @RequestParam("power") int power
                               ) {
        CarDTO car = new CarDTO();
        car.setModel(model);
        car.setProducer(producer);
        car.setPower(power);
        String originalFilename = picture.getOriginalFilename();
        car.setPicture(originalFilename);
        String path = System.getProperty("user.home") + File.separator + "Pictures" + File.separator + originalFilename;
        File transferDestinationFile = new File(path);
        picture.transferTo(transferDestinationFile);
        carService.saveCar(car, transferDestinationFile);
    }
}