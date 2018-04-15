package com.techli.testdrivendesign.service;

import com.techli.testdrivendesign.domain.Car;
import com.techli.testdrivendesign.exception.CarNotFoundException;
import com.techli.testdrivendesign.repository.CarRepository;
/**
 * Service is an intermediate layer between the controller and repository
 * **/
public class CarService {
	
	private CarRepository carRepository;

	

	public CarService(CarRepository carRepository) {

		this.carRepository = carRepository;
	}

	public Car getCarDetails(String name) {
		
		Car car = carRepository.findByName(name);
		if(car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}

}
