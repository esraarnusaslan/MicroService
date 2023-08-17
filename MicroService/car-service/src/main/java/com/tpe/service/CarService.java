package com.tpe.service;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tpe.domain.Car;
import com.tpe.dto.AppLogDTO;
import com.tpe.dto.CarDTO;
import com.tpe.dto.CarRequest;
import com.tpe.enums.AppLogLevel;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;





    //NOT: saveCar()*********************************
    public void saveCar(CarRequest carRequest) {
        Car car=modelMapper.map(carRequest, Car.class);
        carRepository.save(car);

        InstanceInfo instanceInfo= eurekaClient.getApplication("log-service")//yml dosyasindaki name i
                .getInstances().get(0);

        String baseUrl=instanceInfo.getHomePageUrl();//http://localhost:8083        geliyor
        String path="/log";
        String servicePath=baseUrl+path;//http://localhost:8083/log                 olustu

        AppLogDTO appLogDTO=new AppLogDTO();
        appLogDTO.setLevel(AppLogLevel.INFO.name());
        appLogDTO.setDescription("Save a Car: " + car.getId());
        appLogDTO.setTime(LocalDateTime.now());

         ResponseEntity<String> logResponse= restTemplate.postForEntity(servicePath,appLogDTO, String.class);


         if(!(logResponse.getStatusCode()== HttpStatus.CREATED)){
             throw new ResourceNotFoundException("Log not created");
         }

    }


    //NOT: getAllCars()*********************************
    public List<CarDTO> getAllCars() {
        List<Car>carList=carRepository.findAll();
        return carList.stream()
                .map(this::mapCarToCarDTO).collect(Collectors.toList());
    }

    private CarDTO mapCarToCarDTO(Car car){
        return modelMapper.map(car,CarDTO.class);
    }


    //NOT: getById()*********************************
    public CarDTO getById(Long id) {
        Car car=carRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Car no found with id: "+ id));
        CarDTO carDTO=mapCarToCarDTO(car);
        return carDTO;
    }






}
