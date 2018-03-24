package com.devon.dojoninja.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.dojoninja.models.Dojo;

public interface DRepo extends CrudRepository<Dojo, Long> {
	ArrayList<Dojo> findAll();
}
