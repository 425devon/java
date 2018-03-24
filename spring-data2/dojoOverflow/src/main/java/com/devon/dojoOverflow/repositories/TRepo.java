package com.devon.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devon.dojoOverflow.models.Tag;

public interface TRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
}
