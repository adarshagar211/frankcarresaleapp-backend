package com.frank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.frank.model.CarDetails;
import com.frank.service.FrankOlCarService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class FrankOlCarController {

	@Autowired
	private FrankOlCarService frankOlCarService;

	// Get All Car Details for display on UI
	@GetMapping("/warehouse")	
	public ResponseEntity<List<CarDetails>> getAll() {
		log.info("Getting all Car Details present in warehouse");
		try {
			List<CarDetails> carDetails = frankOlCarService.getAll() ;
		    return ResponseEntity.ok(carDetails); 
		}catch(Exception ex) {
			log.debug("Error while retriving data from DB ", ex);
			return ResponseEntity.internalServerError().build();
		}
	}

	// Get More Car Details for vehicle click on UI
  	@GetMapping("/warehouse/{warehouseid}/vehicleId/{vehicleId}")
	public ResponseEntity<CarDetails> getCarDetails(@PathVariable String warehouseid, @PathVariable String vehicleId) throws Exception {
		log.info("Getting requested Car Detail present in warehouse");
		try {
			CarDetails carDetails = frankOlCarService.getCarDetails(warehouseid, vehicleId);
			return ResponseEntity.ok(carDetails); 
		}catch(Exception ex) {
			log.debug("Error while retriving data from DB ", ex);
			return ResponseEntity.internalServerError().build();
		}
	}
	
    // Shopping Cart related API for update and retrieve shopping Cart 
	/*@GetMapping("/shoppingcart")
	public List<Vehicle> getShoppingCartList() throws Exception {
		return frankOlCarService.getShoppingCartList();
	}

	@PostMapping("/update/shoppingcart")
	public List<Vehicle> getShoppingCartList(@RequestBody CarDetails carDetails)
			throws Exception {
		return frankOlCarService.updateShoppingCart(carDetails);
	}*/
}
