package com.frank.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ShoppingCartList {

	@Id
	private String _id ;
	private String userid;
	private String username;
	private List<Vehicle> shoppingCartItem ;
	private String userData;
}
