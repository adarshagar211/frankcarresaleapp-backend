package com.frank.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CarDetails implements Serializable{

	private static final long serialVersionUID = -5006198098755345999L;
	
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
	private LocalDate  dateAdded;
}
