package com.frank.model;

import java.io.Serializable;
import java.util.List;

public class ShoppingCartList implements Serializable{

	private static final long serialVersionUID = -7285754929128206418L;
	
	private String _id ;
	private List<CarDetails> shoppingCartItem ;
}
