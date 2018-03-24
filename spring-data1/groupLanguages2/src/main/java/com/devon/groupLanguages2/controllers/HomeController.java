	package com.devon.groupLanguages2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.groupLanguages2.models.Language;
import com.devon.groupLanguages2.services.LanguageService;


@Controller
@RequestMapping("/")
public class HomeController {
	private final LanguageService languageService;
	
	public HomeController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String home(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/{id}")
	public String findLangaugeById(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		model.addAttribute("language", language);
		System.out.println(model.toString());
		return "showLanguage.jsp";
	}
	@RequestMapping("/new")
	public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "dashboard.jsp";
		}else {
		languageService.addLanguage(language);
		return "redirect:/";
		}
	}
	@RequestMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		if(language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}else {
		return "redirect:/";
		}
	}
	@PostMapping("/update/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }else{
            languageService.updateLanguage(language);
            return "redirect:/";
        }
    }
}
