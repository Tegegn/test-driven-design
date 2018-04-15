package com.techli.testdrivendesign;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.techli.testdrivendesign.domain.Car;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getCar_returnsCarDetails() throws Exception{
		
		
		
		//arrange
		
		//act
		ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("prius");
		assertThat(response.getBody().getType()).isEqualTo("hybrid");
	
	
		
	}

}
