package com.devon.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.auth.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
	@Query(value="SELECT * FROM events where state = ?1", nativeQuery=true)
	List<Event> getEventsByState(String state);
	
	@Query(value="SELECT * FROM events where state != ?1", nativeQuery=true)
	List<Event> awayEvents(String state);
}
