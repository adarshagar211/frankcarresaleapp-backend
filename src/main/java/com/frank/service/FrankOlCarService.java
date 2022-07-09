package com.frank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.frank.model.CarDetails;
import com.frank.model.ShoppingCartList;
import com.frank.model.Vehicle;
import com.frank.model.Warehouse;
import com.frank.repository.ShoppingCartRepository;
import com.frank.repository.WarehouseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FrankOlCarService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public List<CarDetails> getAll() {
		return this.convertToVehicle(warehouseRepository.findAll());
	}

	public Warehouse getCarDetails(@PathVariable String warehouseid) throws Exception {
		Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new Exception("Not found"));
		return warehouse;
	}

	public List<Vehicle> getShoppingCartList(@PathVariable String userid) throws Exception {
		ShoppingCartList shoppingCartList = shoppingCartRepository.findById(userid)
				.orElseThrow(() -> new Exception("Not found"));
		return shoppingCartList.getShoppingCartItem();
	}

	public List<Vehicle> getShoppingCartList(@PathVariable String userid, @RequestBody Vehicle vehicle)
			throws Exception {
		ShoppingCartList shoppingCartList = shoppingCartRepository.findById(userid)
				.orElseThrow(() -> new Exception("Not found"));
		shoppingCartList.getShoppingCartItem().add(vehicle);
		shoppingCartRepository.save(shoppingCartList);
		return shoppingCartList.getShoppingCartItem();
	}

	private List<CarDetails> convertToVehicle(List<Warehouse> warehouses) {
		List<CarDetails> carDetails = new ArrayList<>();
		warehouses.stream().forEach(x -> {
			x.getCars().getVehicles().forEach(y -> {
				CarDetails cardetail = CarDetails.builder().warehouseId(x.get_id()).warehouseName(x.getName())
						.carLocation(x.getCars().getLocation()).location(x.getLocation()).licensed(y.isLicensed())
						.dateAdded(y.getDateAdded()).make(y.getMake()).model(y.getModel()).price(y.getPrice())
						.vehicleId(y.get_id()).yearModel(y.getYearModel()).build();
				carDetails.add(cardetail);
			});
		});
		return carDetails;

	}
}
