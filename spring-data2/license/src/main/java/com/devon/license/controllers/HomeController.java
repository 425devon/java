package com.devon.license.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.license.models.License;
import com.devon.license.models.Person;
import com.devon.license.services.LService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final LService lService;
	public HomeController(LService lService) {
		this.lService = lService;
	}
	
	@RequestMapping("")
	public String home(@ModelAttribute("person")Person person, Model model) {
		return "newPerson.jsp";
	}
	@RequestMapping("/createPerson")
	public String addPerson(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "newPerson.jsp";
		}else {
			lService.addPerson(person);
			System.out.println(lService.allPeople());
		}
		return("redirect:/");
	}
	@RequestMapping("/license")
	public String liscense(@ModelAttribute("license")License license, Model model) {
		ArrayList<Person> persons = lService.allPeople();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	@RequestMapping("/createLicense")
	public String addLiscense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "license.jsp";
		}else {
			
			lService.addLicense(license);
		}
		return "redirect:/license";
	}
	@RequestMapping("/person/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = lService.findByID(id);
		model.addAttribute("person", person);
		return "showAll.jsp";
	}
}
