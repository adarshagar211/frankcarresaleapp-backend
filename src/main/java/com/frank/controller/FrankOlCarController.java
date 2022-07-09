package com.frank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frank.model.CarDetails;
import com.frank.model.Vehicle;
import com.frank.model.Warehouse;
import com.frank.service.FrankOlCarService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class FrankOlCarController {

	@Autowired
	private FrankOlCarService frankOlCarService;

	@GetMapping("/warehouse")	
	public List<CarDetails> getAll() {
		return frankOlCarService.getAll();
	}

	@GetMapping("/warehouse/{warehouseid}")
	public Warehouse getCarDetails(@PathVariable String warehouseid) throws Exception {
		Warehouse warehouse = frankOlCarService.getCarDetails(warehouseid);
		return warehouse;
	}

	@GetMapping("/getUser/{userid}/shoppingcart")
	public List<Vehicle> getShoppingCartList(@PathVariable String userid) throws Exception {
		return frankOlCarService.getShoppingCartList(userid);
	}

	@PostMapping("/getUser/{userid}/shoppingcart")
	public List<Vehicle> getShoppingCartList(@PathVariable String userid, @RequestBody Vehicle vehicle)
			throws Exception {
		return frankOlCarService.getShoppingCartList(userid);
	}
	
	
}
