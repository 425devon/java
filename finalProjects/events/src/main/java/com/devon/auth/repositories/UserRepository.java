package com.devon.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.auth.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	List<User> findAll();
	
	@Query(value="select username from users_roles join users on user_id = users.id where role_id = 2", nativeQuery=true)
	List<Object> findAllAdmins();
	
	@Query(value="SELECT username FROM users", nativeQuery=true)
	List<Object> findAllUsernames();
	
	
}
