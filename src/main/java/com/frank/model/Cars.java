package com.frank.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cars implements Serializable{
	
	private static final long serialVersionUID = -5555271954524081317L;
	
	private String location;
	private List<Vehicle> vehicles;
}
