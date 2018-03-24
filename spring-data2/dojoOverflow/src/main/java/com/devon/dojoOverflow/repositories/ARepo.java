package com.devon.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devon.dojoOverflow.models.Answer;

public interface ARepo extends CrudRepository<Answer, Long> {
	List<Answer> findAll();
}
