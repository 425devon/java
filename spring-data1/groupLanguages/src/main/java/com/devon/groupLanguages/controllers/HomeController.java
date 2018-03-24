package com.devon.groupLanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.groupLanguages.models.Language;
import com.devon.groupLanguages.services.LanguageService;

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
	
	@RequestMapping("/{index}")
	public String findLangaugeByIndex(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		model.addAttribute("language", language);
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
	@RequestMapping("/delete/{index}")
	public String deleteLanguage(Model model, @PathVariable("index") int index) {
		languageService.destroyLanguage(index);
		return "redirect:/";
	}
	@RequestMapping("/edit/{index}")
	public String showLanguage(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		if(language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}else {
		return "redirect:/";
		}
	}
	@PostMapping("/update/{index}")
    public String updateLanguage(@PathVariable("index") int index, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }else{
            languageService.updateLanguage(index, language);
            return "redirect:/";
        }
    }
}
