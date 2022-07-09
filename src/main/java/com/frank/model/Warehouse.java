package com.frank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("warehouses")
public class Warehouse {
	
	@Id
	private String _id;
	private String name;
	private Location location;
	private Cars cars; 
	
}
