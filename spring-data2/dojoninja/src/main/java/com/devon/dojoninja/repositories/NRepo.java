package com.devon.dojoninja.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.dojoninja.models.Ninja;

public interface NRepo extends CrudRepository<Ninja, Long> {
	ArrayList<Ninja> findAll();

}
