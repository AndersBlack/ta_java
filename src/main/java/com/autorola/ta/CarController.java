package com.autorola.ta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarController {

  @Autowired
  CarService carService;

  @GetMapping("/cars")
	public List<Car> all_cars () {
		return carService.return_all_cars();
	}

  @GetMapping("/cars/{vin}")
	public Car get_single_car(@PathVariable("vin") String vin) throws NotFound {
    var optional_car = carService.return_car(vin);

		if (optional_car.isPresent()) {
      return optional_car.get();
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"
      );
    }
	}

  @PostMapping("/cars")
	public String create_car( @RequestBody Request_Car rCar) {
		var res = carService.create_car(rCar.make, rCar.model, rCar.mileage);
    return res;
	}

  @PostMapping("/cars/{vin}")
	public String update_car( @PathVariable("vin") String vin, @RequestBody Request_Car rCar) throws NotFound {
		var updated_car = carService.update_car(vin, rCar.make, rCar.model, rCar.mileage);
    
    if (updated_car) {
      return "Updated car";
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"
      );
    }
	}

  @DeleteMapping("/cars/{vin}")
	public String delete_car(@PathVariable("vin") String vin) throws NotFound {
		var deleted_car = carService.delete_car(vin);
    
    if (deleted_car) {
      return "Deleted car";
    } else {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"
      );
    }
	}
}
