package com.techli.testdrivendesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techli.testdrivendesign.Exception.CarNotFoundException;
import com.techli.testdrivendesign.domain.Car;
import com.techli.testdrivendesign.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void carNotFoundHandler(CarNotFoundException ex) {
		
		/**
		 * Its advised to use exception handler but if u don want to u
		 *  can add @ResponseStatus on top of CarNotFoundException class
		 *  and it should work fine
		 * **/
	}

}
