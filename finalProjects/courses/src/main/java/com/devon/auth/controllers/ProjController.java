package com.devon.auth.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devon.auth.models.Course;
import com.devon.auth.models.User;
import com.devon.auth.services.UserService;

@Controller
public class ProjController {
	private UserService userService;
    
    public ProjController(UserService userService) {
    	this.userService = userService;
    }
    
    @RequestMapping("/dash")
    public String showDash(Principal principal, Model model) {
    	String username = principal.getName();
    	List<Course> allCourses = userService.allCourses();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("allCourses", allCourses);
    	return("homePage.jsp");
    }
    @RequestMapping("/addCourse/{uid}")
    public String addCourse(@ModelAttribute("course")Course course, @PathVariable("uid")Long uid, Model model) {
    	User curU = userService.findUserById(uid);
    	model.addAttribute("currentUser", curU);
    	return("newCourse.jsp");
    }
    @RequestMapping("/createCourse/{uid}")
    public String createCourse(@Valid @ModelAttribute("course")Course course, BindingResult result, @PathVariable("uid")Long uid, Model model) {
    	if (result.hasErrors()) {
            return "newCourse.jsp";
        }else {
        	User curU = userService.findUserById(uid);
        	userService.saveCourseWithUser(course, curU);
        }
    	return("redirect:/dash");
    }
    @RequestMapping("/course/{cid}/{uid}")
    public String showCourse(@PathVariable("cid")Long cid, @PathVariable("uid")Long uid, Model model) {
    	User curU = userService.findUserById(uid);
    	Course curC = userService.findCourseById(cid);
    	model.addAttribute("course", curC);
    	model.addAttribute("currentUser", curU);
    	return("showCourse.jsp");
    }
    @RequestMapping("/edit/{cid}")
    public String showEdit(@PathVariable("cid")Long cid, Model model) {
    	Course curC = userService.findCourseById(cid);
    	model.addAttribute("course", curC);
    	return("editCourse.jsp");
    }
    @RequestMapping("/editCourse/{cid}")
    public String editCourse(@PathVariable("cid")Long cid,
    		@RequestParam(value="name" ,required = false) String name,
    		@RequestParam(value="instructor",required = false) String instructor,
    		@RequestParam(value="classSize",required = false) String classSize,RedirectAttributes redirectAttributes, Model model, 
    		@ModelAttribute("logoutMessage")String logoutMessage) {
    	Course curC = userService.findCourseById(cid);
    	if(name.length() < 1) {
    		redirectAttributes.addFlashAttribute("logoutMessage", "Name must be filled in");
    		return("redirect:/edit/"+cid);
    	}
    	curC.setName(name);
    	if(instructor.length() < 1) {
    		redirectAttributes.addFlashAttribute("logoutMessage", "Instructor must be filled in");
    		return("redirect:/edit/"+cid);
    	}
    	curC.setInstructor(instructor);
    	if(classSize.length() < 1) {
    		redirectAttributes.addFlashAttribute("logoutMessage", "Name must be filled in");
    		return("redirect:/edit/"+cid);
    	}
    	int size = Integer.parseInt(classSize);
    	curC.setClassSize(size);
    	
    	userService.saveCourse(curC);
    	
    	return("redirect:/dash");
    }
    @RequestMapping("/delete/{cid}")
    public String deleteCourse(@PathVariable("cid")Long cid) {
    	userService.deleteCourseById(cid);
    	return("redirect:/dash");
    }
    @RequestMapping("/remove/{cid}/{uid}")
    public String removeCourse(@PathVariable("cid")Long cid, @PathVariable("uid")Long uid) {
    	userService.removeCourse(uid, cid);
    	return("redirect:/course/"+cid+"/"+uid);
    }
    @RequestMapping("/join/{cid}/{uid}")
    public String joinCourse(@PathVariable("cid")Long cid, @PathVariable("uid")Long uid) {
    	Course curC = userService.findCourseById(cid);
    	User curU = userService.findUserById(uid);
    	curU.getCourses().add(curC);
    	userService.saveUser(curU);
    	return("redirect:/dash");
    }
    
}
