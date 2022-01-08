package com.example.carsystem.cotroller;

import com.example.carsystem.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static java.lang.Double.parseDouble;


import java.util.Calendar;

import java.util.ArrayList;


@RestController
public class CarController {
    ArrayList<Car> cars=new ArrayList<>();

    @GetMapping(path="/cars")
    public ArrayList<Car> getCars(){
        return cars;
    }


@GetMapping(path = "/car")
public ResponseEntity<String> getSomeCar(@RequestParam double price,@RequestParam int yerOfMake,@RequestParam String color) {
    for (int i = 0; i < cars.size(); i++) {
        Car u = cars.get(i);
        if (cars.get(i).getPrice() == price && cars.get(i).getYearOfMake() == yerOfMake && cars.get(i).getColor().equals(color)) {
            return ResponseEntity.status(200).body("The id of this type of cars is " + cars.get(i).getId());
        }
    }
    return ResponseEntity.status(400).body("No Car in this  ");
}
    @PostMapping(path="/addCar")
    public ResponseEntity<String> addCar(@RequestBody Car car){
       if(!checkInput(car)){
           return ResponseEntity.status(400).body("Please Fill all the Fields");
       }
        for (int i = 0; i <cars.size() ; i++) {
            if(cars.get(i).getId().equals(car.getId())){
                return ResponseEntity.status(400).body("Car Id already exist");
            }
        }
        cars.add(car);
        return ResponseEntity.status(200).body("Car Add Successes");
    }
    @PostMapping(path="/sellCar/{id}")
    public ResponseEntity<String> sellCar(@PathVariable String id, @RequestBody String amount){
        for (int i = 0; i < cars.size(); i++) {
            Car u=cars.get(i);

            if (id.equals(cars.get(i).getId()) && parseDouble(amount) == u.getPrice()) {
                cars.remove(i);
                return ResponseEntity.status(200).body("Successes selling ");

            }else if (id.equals(cars.get(i).getId()) && parseDouble(amount) > u.getPrice()) {

              double yourRest  =parseDouble(amount)- u.getPrice();
                cars.remove(i);
            return ResponseEntity.status(200).body("Successes selling , Your Rest is :  "+ yourRest );

        }
            return ResponseEntity.status(400).body("your amount less than price !! Car price is :  "+ u.getPrice() );
    }
        return ResponseEntity.status(400).body("user not found");
}

    @DeleteMapping(path = "/deleteCars")
    public ResponseEntity<String> deleteCars() {
        Calendar calendar = Calendar.getInstance();
       int date = calendar.get(Calendar.YEAR);

        for (int i = 0; i < cars.size() ; i++) {
                if(cars.get(i).getYearOfMake() < (date-5) ){
                    cars.remove(i);
              return ResponseEntity.status(200).body("Car Deleted");
            }
        }
        return ResponseEntity.status(400).body("No Car Fount less than :"+(date-5));
    }

    public boolean checkInput(Car car){
        if(car.getId()==null||car.getModel()==null||car.getYearOfMake()==0||car.getColor()==null||car.getPrice()==0.0){
            return false;
        }
        return true;
    }
}
