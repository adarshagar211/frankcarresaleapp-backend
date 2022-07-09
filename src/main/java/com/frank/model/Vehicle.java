package com.frank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
	private int _id;
	private String make;
	private String model;
	private int yearModel;
	private double price;
	private boolean licensed;
	private String dateAdded;
}
