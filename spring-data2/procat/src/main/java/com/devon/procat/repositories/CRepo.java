package com.devon.procat.repositories;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.procat.models.Category;

public interface CRepo extends CrudRepository<Category, Long> {
	ArrayList<Category> findAll();
}
