package com.autorola.ta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CarService {
  private List<Car> car_list;

  public CarService () {
    this.car_list = new ArrayList<Car>();
  }

  public List<Car> return_all_cars () {
    return this.car_list;
  }

  public boolean update_car(String vin, String make, String model, String mileage) {

    for (Car car : car_list) {

      if (vin.equals(car.vin)) {
        car.make = make;
        car.model = model;
        car.mileage = mileage;

        return true;
      }
    }

    return false;
  } 

  public Optional<Car> return_car(String vin) {
    for (Car car : car_list) {
      if (vin.equals(car.vin)) {
        return Optional.of(car);
      }
    }

    return Optional.empty();
  }

  public String create_car(String make, String model, String mileage) {
    Car new_car = new Car(make, model, mileage);
    car_list.add(new_car); 
    return "Created car";
  }

  public boolean delete_car(String vin) {
    for (Car car : car_list) {
      if (vin.equals(car.vin)) {
        car_list.remove(car);
        return true;
      }
    }

    return false;
  } 
}
