package com.frank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.frank.model.ShoppingCartList;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCartList, String> {

}
