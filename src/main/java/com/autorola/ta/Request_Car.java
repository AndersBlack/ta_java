package com.autorola.ta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request_Car {
  @JsonProperty("make")
  String make;
  @JsonProperty("model")
  String model;
  @JsonProperty("mileage")
  String mileage;
}