package com.chessa.example.jpacrud.onetomany.jpaOnetoMany.controller;



import com.chessa.example.jpacrud.onetomany.jpaOnetoMany.model.Cars;
import com.chessa.example.jpacrud.onetomany.jpaOnetoMany.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarRepository carRepository;
    //get all
    @GetMapping("/cars")
//    public List<Cars> getAllCars(){
        public List<Cars> getAllCars(){
        return carRepository.findAll();
    }
    //get one by id
    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable(value = "id") Long carId){
        Cars car = carRepository.findOne(carId);
        if (car==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(car);
    }
    //create new one
    @PostMapping("/cars")
    public Cars createCar(@Valid @RequestBody Cars car){
        return carRepository.save(car);
    }
    //edit one of them
    @PutMapping("/cars/{id}")
    public ResponseEntity<Cars> updateCar(
            @PathVariable(value = "id")Long carId, @Valid @RequestBody Cars carDetail){
        Cars car= carRepository.findOne(carId);
        if (car==null){
            return ResponseEntity.notFound().build();
        }
        car.setName(carDetail.getName());
        car.setBrand(carDetail.getBrand());
        car.setColor(carDetail.getColor());
        car.setVehicle_number(carDetail.getVehicle_number());
        car.setOwners_id(carDetail.getOwners_id());
        Cars updateCar= carRepository.save(car);
        return ResponseEntity.ok(updateCar);
    }
    //delete one of them by id
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Cars> deleteCar(@PathVariable(value = "id")Long carId){
        Cars car= carRepository.findOne(carId);
        if (car==null){
            return ResponseEntity.notFound().build();
        }
        carRepository.delete(car);
        return ResponseEntity.ok().build();
    }

}
