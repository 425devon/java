package com.devon.license.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.license.models.License;


public interface LRepo extends CrudRepository<License, Long> {
	ArrayList<License> findAll();
	
}
