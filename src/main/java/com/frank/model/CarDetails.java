package com.frank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CarDetails {

	private String warehouseId;
	private String warehouseName;
	private Location location;
	private String carLocation;
	private int vehicleId;
	private String make;
	private String model;
	private int yearModel;
	private double price;
	private boolean licensed;
	private String dateAdded;
}
