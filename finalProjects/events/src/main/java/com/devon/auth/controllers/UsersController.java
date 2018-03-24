package com.devon.auth.controllers;


import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devon.auth.models.Comment;
import com.devon.auth.models.Event;
import com.devon.auth.models.User;
import com.devon.auth.services.UserService;
import com.devon.auth.validator.UserValidator;


@Controller
public class UsersController {
    private UserService userService;
    private UserValidator userValidator;
    
    public UsersController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session, @RequestParam("username")String username) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
    	if(userService.allUsernames().contains(username) == true) {
    		model.addAttribute("logoutMessage", "User already exists!");
    		return "registrationPage.jsp";
    	}
    	//check if admin currently exists in all users
    	if(userService.allAdmins().size() != 0) {
    		userService.saveWithUserRole(user);
    	}else {
    		userService.saveUserWithAdminRole(user);
    	}
        model.addAttribute("successMessage", "Registration Successful please log in!");
        return "redirect:/";
    }
    @RequestMapping("/logo")
    public String update(Principal principal, Model model, RedirectAttributes redirectAttributes) {
    	String username = principal.getName();
        User curU = userService.findByUsername(username);
        curU.setUpdatedAt(new Date());
        userService.saveUser(curU);
        redirectAttributes.addFlashAttribute("logoutMessage", "Logout Successful!");
        return ("redirect:/login");
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        return "registrationPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, @ModelAttribute("event")Event event) {
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	String state = currentUser.getState();
        model.addAttribute("currentUser", currentUser);
        List<Event> eventsByState = userService.eventsByState(state);
        model.addAttribute("eventsByState", eventsByState);
        List<Event> otherEvents = userService.otherEvents(state);
        model.addAttribute("otherEvents", otherEvents);
        /*System.out.println(userService.findByUsername(username).roleId());
        if(currentUser.roleId() == 1) {
        	return("homePage.jsp");
        }else {
        	if(currentUser.roleId() == 2) {
        	model.addAttribute("allUsers", userService.allUsers());
        	return("adminPage.jsp");
        	}
        }*/
        return("homePage.jsp");
    }
    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id) {
    	userService.deleteUser(id);
    	return("redirect:/");
    }
    
    @RequestMapping("/admin/mkAdmin/{id}")
    public String makeAdmin(@PathVariable("id")Long id) {
    	User newAdmin = userService.findById(id);
    	userService.saveUserWithAdminRole(newAdmin);
    	return("redirect:/");
    }
    @RequestMapping("/newEvent/{id}")
    public String newEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, @PathVariable("id")Long id) {
    	if (result.hasErrors()) {
            return "homePage.jsp";
        }else {
        	User curU = userService.findById(id);
        	userService.saveEventWithUser(event, curU);
        }
    	return("redirect:/");
    }
    @RequestMapping("/event/{id}")
    public String showEvent(@PathVariable("id")Long id, Model model, @ModelAttribute("com")Comment comment, Principal principal) {
    	Event curE = userService.getEventById(id);
    	List<User> attending = curE.getUsers();
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	model.addAttribute("currentUser", currentUser);
    	model.addAttribute("event", curE);
    	model.addAttribute("attending", attending);
    	return("showEvent.jsp");
    }
    @RequestMapping("/newComment/{eid}/{uid}")
    public String saveComment(@Valid @ModelAttribute("com")Comment comment, BindingResult result,@PathVariable("eid")Long eid, @PathVariable("uid")Long uid) {
    	if (result.hasErrors()) {
            return "redirect:/event/"+eid;
        }else {
        	User curU = userService.findById(uid);
        	Event curE = userService.getEventById(eid);
        	userService.SaveCommentWithEventAndUser(comment, curE, curU);
        }
    	return "redirect:/event/"+eid;
    }
    @RequestMapping("/event/delete/{eid}/{uid}")
    public String deleteEvent(@PathVariable("eid")Long eid,@PathVariable("uid")Long uid) {
    	userService.deleteEventById(eid);
    	return("redirect:/");
    }
    @RequestMapping("/event/join/{eid}/{uid}")
    public String joinEvent(@PathVariable("eid")Long eid,@PathVariable("uid")Long uid) {
    	userService.joinEvent(uid, eid);
    	return("redirect:/");
    }
    @RequestMapping("/event/cancel/{eid}/{uid}")
    public String cancelJoin(@PathVariable("eid")Long eid,@PathVariable("uid")Long uid) {
    	userService.cancelJoin(uid, eid);
    	return("redirect:/");
    }
    @RequestMapping("/event/edit/{eid}/{uid}")
    public String editEvent(@PathVariable("eid")Long eid,@PathVariable("uid")Long uid, Model model, Principal principal) {
    	Event event = userService.getEventById(eid);
    	User curU = userService.findById(uid);
    	String uname = curU.getUsername();
    	String validName = principal.getName();
    	if(!uname.equals(validName)) {
    		return("redirect:/");
    	}
    	model.addAttribute("event", event);
    	model.addAttribute("currentUser", curU);
    	
    	return("editEvent.jsp");
    }
    @RequestMapping("/editEvent/{eid}/{uid}")
    public String makeEdits(@PathVariable("eid")Long eid,@PathVariable("uid")Long uid,
    		@RequestParam(value="name") String name,
    		@RequestParam(value="time") String time,
    		@RequestParam(value="location") String location,
    		@RequestParam(value="state") String state,
    		@RequestParam(value="host") String host) {
    	
    	Event curE = userService.getEventById(eid);
    	curE.setName(name);
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println(time);
    	Date newTime;
		try {
			newTime = formatter.parse(time);
			curE.setTime(newTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		curE.setLocation(location);
		curE.setState(state);
		curE.setHost(host);
		
		userService.saveEvent(curE);
    	
    	return("redirect:/");
    }
}
