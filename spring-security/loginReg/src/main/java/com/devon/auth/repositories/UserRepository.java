package com.devon.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.auth.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	@Query(value="SELECT username FROM users", nativeQuery=true)
	List<Object> findAllUsernames();
}
