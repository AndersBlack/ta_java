package com.autorola.ta;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.*;

@Component
public class Car {
  @JsonProperty("vin")
  String vin;
  @JsonProperty("make")
  String make;
  @JsonProperty("model")
  String model;
  @JsonProperty("milage")
  String mileage;
  @JsonProperty("car_creation_time")
  OffsetDateTime car_creation_time;

  public Car () {} 

  public Car(String make, String model, String mileage) {
    this.vin = java.util.UUID.randomUUID().toString();
    this.make = make;
    this.model = model;
    this.mileage = mileage;
    this.car_creation_time = OffsetDateTime.now(); 
  }
}

