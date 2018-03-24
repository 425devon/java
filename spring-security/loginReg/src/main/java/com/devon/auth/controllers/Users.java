package com.devon.auth.controllers;


import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.auth.models.User;
import com.devon.auth.services.UserService;
import com.devon.auth.validator.UserValidator;


@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
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
        userService.saveWithUserRole(user);
        model.addAttribute("successMessage", "Registration Successful please log in!");
        return "redirect:/";
    }
    @RequestMapping("/logo")
    public String update(Principal principal, Model model) {
    	String username = principal.getName();
        System.out.println(username);
        User curU = userService.findByUsername(username);
        curU.setUpdatedAt(new Date());
        userService.saveUser(curU);
        return ("redirect:/login");
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");            
        }
        return "registrationPage.jsp";
    }
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
}