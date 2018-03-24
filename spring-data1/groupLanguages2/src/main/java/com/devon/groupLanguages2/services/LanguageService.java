package com.devon.groupLanguages2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devon.groupLanguages2.models.Language;
import com.devon.groupLanguages2.repositories.LanguageRepository;

@Service
public class LanguageService {

	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language findLanguageById(long id) {
		
        return languageRepository.findById(id).orElse(null);
    }
    

	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
    
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	

	public void destroyLanguage(Long id) {
        languageRepository.deleteById(id);
    }

}