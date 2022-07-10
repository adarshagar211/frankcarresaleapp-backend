package com.frank.model;

import java.time.LocalDate;
import java.util.Date;

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
	private int year_model;
	private double price;
	private boolean licensed;
	private LocalDate date_added;
}
