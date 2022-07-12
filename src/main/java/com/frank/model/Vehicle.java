package com.frank.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle implements Serializable{

	private static final long serialVersionUID = -6809495036931674163L;
	
	private int _id;
	private String make;
	private String model;
	private int year_model;
	private double price;
	private boolean licensed;
	private LocalDate date_added;
}
