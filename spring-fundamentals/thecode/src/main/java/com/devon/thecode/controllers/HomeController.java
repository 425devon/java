package com.devon.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index(@ModelAttribute("errors")String errors) {
		
		return("index.jsp");
	}
	 @RequestMapping(path="/login", method=RequestMethod.POST)
	    public String login(@RequestParam(value="password")String password) {
		 if(!"bushido".equals(password)) {
			 return "redirect:/errors";
		 }
		 if(password.equals("bushido")) {
			 return "code.jsp";
		 }
		 return "redirect:/errors";
	 }
	 @RequestMapping("/errors")
	    public String errors(RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("errors", "You must train harder");
		return "redirect:/";
	 }

}
