package com.devon.auth.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devon.auth.models.Course;
import com.devon.auth.models.User;
import com.devon.auth.repositories.CourseRepo;
import com.devon.auth.repositories.RoleRepository;
import com.devon.auth.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private CourseRepo courseRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, CourseRepo courseRepo, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.courseRepo = courseRepo;
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


    public List<Object> allUsernames(){
    	return userRepository.findAllUsernames();
    	
    }
    public List<User> allUsers(){
    	return userRepository.findAll();
    }
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    public User findUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    public List<Course> allCourses(){
    	return courseRepo.findAll();
    }
    public void saveCourse(Course course) {
    	courseRepo.save(course);
    }
    public void saveCourseWithUser(Course course, User user) {
    	course.getUsers().add(user);
    	courseRepo.save(course);
    }
    public Course findCourseById(Long id) {
    	return courseRepo.findById(id).orElse(null);
    }
    public void deleteCourseById(Long id) {
    	courseRepo.deleteById(id);
    }
    public void removeCourse(Long uid, Long cid) {
    	Course curC = courseRepo.findById(cid).orElse(null);
    	User curU = userRepository.findById(uid).orElse(null);
    	List<Course> userCourses = curU.getCourses();
    	userCourses.remove(curC);
    	curU.setCourses(userCourses);
    	userRepository.save(curU);
    }
}
