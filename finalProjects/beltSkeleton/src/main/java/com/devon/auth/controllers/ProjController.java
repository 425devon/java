package com.devon.auth.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("currentUser", userService.findByUsername(username));
    	return("homePage.jsp");
    }
}
