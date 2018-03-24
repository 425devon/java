package com.devon.displaydate.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
 	public String index() {
	 return "index.jsp";
	}
	@RequestMapping("/date")
 	public String date(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		model.addAttribute("date", dtf.format(localDate));
	 return "date.jsp";
	}
	@RequestMapping("/time")
 	public String time(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("time", dtf.format(now));
	 return "time.jsp";
	}
 
}
