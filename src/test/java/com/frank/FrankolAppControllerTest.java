package com.frank;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.frank.controller.FrankOlCarController;
import com.frank.model.CarDetails;
import com.frank.service.FrankOlCarService;

@SpringBootTest( classes = {TestSecurityConfig.class, MongoConfig.class,FrankOlCarController.class})
@AutoConfigureMockMvc
public class FrankolAppControllerTest {
	  
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FrankOlCarService frankOlCarService;

	@Test
	public void testgetAllCarService() throws Exception {
		List<CarDetails> carDetails = Collections.singletonList(CarDetails.builder().warehouseId("1").build());
		when(frankOlCarService.getAll()).thenReturn(carDetails);
		this.mockMvc.perform(get("/warehouse")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].warehouseId").value("1"));
	}
	
	@Test
	public void testgetAllCarServiceThrowException() throws Exception {
		when(frankOlCarService.getAll()).thenThrow(new RuntimeException());
		this.mockMvc.perform(get("/warehouse")).andDo(print()).andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testgetCarDetails() throws Exception {
		CarDetails carDetails = CarDetails.builder().warehouseId("1").build();
		when(frankOlCarService.getCarDetails("1", "1")).thenReturn(carDetails);
		this.mockMvc.perform(get("/warehouse/1/vehicleId/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.warehouseId").value("1"));
	}
	@Test
	public void testgetCarDetailsThrowException() throws Exception {
		CarDetails carDetails = CarDetails.builder().warehouseId("1").build();
		when(frankOlCarService.getCarDetails("1", "1")).thenThrow(new RuntimeException());
		this.mockMvc.perform(get("/warehouse/1/vehicleId/1")).andDo(print())
		            .andExpect(status().isInternalServerError());
	}
}