package com.devon.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.auth.models.Comment;

@Repository
public interface ComRepo extends CrudRepository<Comment, Long> {

}
