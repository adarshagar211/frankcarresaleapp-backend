package com.frank.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.frank.model.CarDetails;
import com.frank.model.Vehicle;
import com.frank.model.Warehouse;
import com.frank.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FrankOlCarService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	public List<CarDetails> getAll() {
		return convertToVehicle(warehouseRepository.findAll());
	}

	public CarDetails getCarDetails(@PathVariable String warehouseid, String vehicleId) throws Exception {
		CarDetails carDetails = convertToVehicle(warehouseRepository.findById(warehouseid)
				.orElseThrow(() -> new Exception("Warehouse is not found in DB with id ; " + warehouseid)), vehicleId);
		return carDetails;
	}
	
   /* Convert Warehouse details received from DB 
    * to Car details list and sorting by Date Added DESC
    */
	private List<CarDetails> convertToVehicle(List<Warehouse> warehouses) {
		List<CarDetails> carDetails = new ArrayList<>();
		warehouses.forEach(x -> {
			x.getCars().getVehicles().forEach(y -> {
				CarDetails cardetail = CarDetails.builder().warehouseId(x.get_id()).warehouseName(x.getName())
						.carLocation(x.getCars().getLocation()).location(x.getLocation()).licensed(y.isLicensed())
						.dateAdded(y.getDate_added()).make(y.getMake()).model(y.getModel()).price(y.getPrice())
						.vehicleId(y.get_id()).yearModel(y.getYear_model()).build();
				carDetails.add(cardetail);
			});
		});
		carDetails.sort(Comparator.comparing(CarDetails::getDateAdded));
		return carDetails;
	}
	
	   /*  Find Car Details of Vehicle with vehicleId 
	    *  in particular Warehouse with WarehouseId 
	    */
		private CarDetails convertToVehicle(Warehouse warehouses,String vehicleId) throws Exception {
			Vehicle vehicle = warehouses.getCars().getVehicles().stream()
					                              .filter(y -> y.get_id() == Integer.parseInt(vehicleId))
					                              .findAny()
					                              .orElseThrow(() -> new Exception("Vehicle is not found in DB with id ; " + vehicleId));
			
			return CarDetails.builder().warehouseId(warehouses.get_id()).warehouseName(warehouses.getName())
					                   .carLocation(warehouses.getCars().getLocation())
					                   .location(warehouses.getLocation()).licensed(vehicle.isLicensed())
					                   .dateAdded(vehicle.getDate_added()).make(vehicle.getMake())
					                   .model(vehicle.getModel()).price(vehicle.getPrice())
					                   .vehicleId(vehicle.get_id()).yearModel(vehicle.getYear_model()).build();
		}
}
