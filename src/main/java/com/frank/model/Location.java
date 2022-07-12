package com.frank.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable{

	private static final long serialVersionUID = -5432609177315452453L;
	
	private String lat;
	@JsonProperty("long")
	@Field("long")
	private String mylong;
}
