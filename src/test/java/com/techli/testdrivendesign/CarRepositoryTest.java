package com.techli.testdrivendesign;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.techli.testdrivendesign.domain.Car;
import com.techli.testdrivendesign.repository.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void getCar_returnsCarDetails() throws Exception {
		
		Car savedCar = 	entityManager.persistFlushFind(new Car("prius", "hybrid"));
		Car car = repository.findByName("prius");
		
		assertThat(car.getName()).isEqualTo(savedCar.getName());
		assertThat(car.getType()).isEqualTo(savedCar.getType());
		
		//assertThat(car.getName()).isEqualTo("prius");
	}
	
}
