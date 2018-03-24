package com.devon.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.auth.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
