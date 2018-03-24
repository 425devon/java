package com.devon.learnPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String dashboard() {
		
		return("dashboard.jsp");
	}
	@RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
	public String showLesson(@PathVariable("chapter") String chapter,
							@PathVariable("assignmentNumber")String asgn,
							Model model) {
		if(asgn.equals("0773")) {
		model.addAttribute("cat", "Setting up your servers");
		}
		if(asgn.equals("0342")) {
		model.addAttribute("cat", "Punch Cards");
		}
		if(asgn.equals("0348")) {
		model.addAttribute("cat", "Advanced Fortran Intro");
		}
		
		System.out.println(asgn);
		return("lesson.jsp");
	}

	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
	public String showAssignment(@PathVariable("chapter") String chapter,
			@PathVariable("assignmentNumber") String asgn,
			Model model) {
		if(asgn.equals("0345")) {
		model.addAttribute("cat", "Coding Forms");
		}
		if(asgn.equals("0342")) {
		model.addAttribute("cat", "Punch Cards");
		}
		if(asgn.equals("2342")) {
		model.addAttribute("cat", "Fortran to Binary");
		}
			
		
		return("assignment.jsp");
	}
	
}
