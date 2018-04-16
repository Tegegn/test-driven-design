package com.techli.testdrivendesign.repository;

import org.springframework.data.repository.CrudRepository;

import com.techli.testdrivendesign.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

	Car findByName(String name); 

}
