package com.devon.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devon.dojoOverflow.models.Question;

public interface QRepo extends CrudRepository<Question, Long> {
	List<Question> findAll();
}
