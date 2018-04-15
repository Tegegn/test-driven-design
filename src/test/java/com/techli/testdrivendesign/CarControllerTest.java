package com.techli.testdrivendesign;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.techli.testdrivendesign.Exception.CarNotFoundException;
import com.techli.testdrivendesign.controller.CarController;
import com.techli.testdrivendesign.domain.Car;
import com.techli.testdrivendesign.service.CarService;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean // @MockBean involves spring context while @Mock doesn't
	private CarService carService;
	
	@Test
	public void getCar_ShouldReturnCar() throws Exception {
		
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius")).andExpect(status().isOk())
				.andExpect(jsonPath("name").value("prius"))
				.andExpect(jsonPath("type").value("hybrid"));
		
	}
	
	@Test
	public void getCar_notFound() throws Exception {
		given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius")).andExpect(status().isNotFound());

	}
	
}
