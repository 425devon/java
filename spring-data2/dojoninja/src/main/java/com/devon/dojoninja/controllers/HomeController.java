package com.devon.dojoninja.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.dojoninja.models.Dojo;
import com.devon.dojoninja.models.Ninja;
import com.devon.dojoninja.services.NService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final NService nService;
	public HomeController(NService nService) {
		this.nService = nService;
	}
	@RequestMapping("")
	public String home(@ModelAttribute("dojo") Dojo dojo) {
		return "home.jsp";
	}
	@RequestMapping("/newDojo")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "home.jsp";
		}else {
			nService.addDojo(dojo);
		}
		return "redirect:/ninja";
	}
	@RequestMapping("/ninja")
	public String ninjaHome(@ModelAttribute("ninja") Ninja ninja, Model model) {
		ArrayList<Dojo> dojos = nService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	@RequestMapping("/newNinja")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "ninja.jsp";
		}else {
			nService.addNinja(ninja);
		}
		return "redirect:/ninja";
	}
	@RequestMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojos = nService.findDojoById(id);
		System.out.println(dojos);
		model.addAttribute("dojos", dojos);
		return "dojo.jsp";
	}

}
