package com.devon.procat.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.procat.models.Product;

public interface PRepo extends CrudRepository<Product, Long> {
	ArrayList<Product> findAll();
}
