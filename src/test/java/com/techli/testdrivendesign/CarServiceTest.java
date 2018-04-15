package com.techli.testdrivendesign;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.*;

import com.techli.testdrivendesign.domain.Car;
import com.techli.testdrivendesign.exception.CarNotFoundException;
import com.techli.testdrivendesign.repository.CarRepository;
import com.techli.testdrivendesign.service.CarService;
/**
 * pure junit and basic mockito test with out involving any spring context
 *
 * **/

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
	
	@Mock
	private CarRepository carRepository;
	
	private CarService carService;
	
	@Before
	public void setup() throws Exception {
		carService = new CarService(carRepository);
	}
	
	@Test
	public void getCarDetails_returnsCarInfo() {
		given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));
		
		Car car = carService.getCarDetails("prius");
		
		assertThat(car.getName()).isEqualTo("prius");
		assertThat(car.getType()).isEqualTo("hybrid");
	}
	
	@Test(expected = CarNotFoundException.class)
	public void getCarDetails_whenCarNotFound() throws Exception {
		
		given(carRepository.findByName("prius")).willReturn(null);

	}

}
