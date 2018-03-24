package com.devon.license.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.license.models.Person;

public interface PRepo extends CrudRepository<Person, Long> {
	ArrayList<Person> findAll();
}
