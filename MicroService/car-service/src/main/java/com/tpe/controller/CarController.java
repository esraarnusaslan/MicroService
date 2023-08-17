package com.tpe.controller;

import com.tpe.dto.CarDTO;
import com.tpe.dto.CarRequest;
import com.tpe.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;




    //NOT: saveCar()*********************************
    @PostMapping//http://localhost:8085/car   +   POST
    public ResponseEntity<Map<String,String>> saveCar(@RequestBody CarRequest carRequest){

        carService.saveCar(carRequest);

        Map<String,String> map=new HashMap<>();
        map.put("message", "Car Successfully saved");
        map.put("success","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }



    //NOT: getAllCars()*********************************
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<CarDTO> allCars=carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }



    //NOT: getById()*********************************
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id){
        CarDTO carDTO=carService.getById(id);
        return ResponseEntity.ok(carDTO);
    }





}
