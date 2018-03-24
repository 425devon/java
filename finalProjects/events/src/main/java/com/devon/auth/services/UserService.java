package com.devon.auth.services;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devon.auth.models.Comment;
import com.devon.auth.models.Event;
import com.devon.auth.models.Role;
import com.devon.auth.models.User;
import com.devon.auth.repositories.ComRepo;
import com.devon.auth.repositories.EventRepo;
import com.devon.auth.repositories.RoleRepository;
import com.devon.auth.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ComRepo comRepo;
    private EventRepo eventRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, ComRepo comRepo, EventRepo eventRepo, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.comRepo = comRepo;
        this.eventRepo = eventRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void saveUser(User user) {
    	userRepository.save(user);
    }
    //admin methods
    public List<Object> allAdmins(){
    	return userRepository.findAllAdmins();
    }
    public List<User> allUsers(){
    	return userRepository.findAll();
    }
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    public User findById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    public Role getRoleById(Long id) {
    	return roleRepository.findById(id).orElse(null);
    }
    ///
    public Event saveEvent(Event event) {
    	eventRepo.save(event);
    	return event;
    }
    public void saveEventWithUser(Event event, User user) {
    	event.getUsers().add(user);
    	eventRepo.save(event);
    }
    public List<Event> eventsByState(String state){
    	return eventRepo.getEventsByState(state);
    }
    public List<Event> otherEvents(String state){
    	return eventRepo.awayEvents(state);
    }
    public List<Object> allUsernames(){
    	return userRepository.findAllUsernames();
    	
    }
    public Event getEventById(Long id) {
    	return eventRepo.findById(id).orElse(null);
    }
    
    public void saveComment(Comment comment) {
    	comRepo.save(comment);
    }
    public void SaveCommentWithEventAndUser(Comment comment, Event event, User user) {
    	comment.setEvent(event);
    	comment.setUser(user);
    	comRepo.save(comment);
    }
    public void deleteEventById(Long id) {
    	Event curE = eventRepo.findById(id).orElse(null);
    	eventRepo.delete(curE); 
    }
    public void joinEvent(Long uid, Long eid) {
    	Event curE = eventRepo.findById(eid).orElse(null);
    	User curU = userRepository.findById(uid).orElse(null);
    	curU.getEvents().add(curE);
    	userRepository.save(curU);
    }
    public void cancelJoin(Long uid, Long eid) {
    	Event curE = eventRepo.findById(eid).orElse(null);
    	User curU = userRepository.findById(uid).orElse(null);
    	List<Event> userEvents = curU.getEvents();
    	userEvents.remove(curE);
    	curU.setEvents(userEvents);
    	userRepository.save(curU);
    }
}
