package com.devon.groupLanguages.services;

import java.util.ArrayList;
import java.util.List;

import com.devon.groupLanguages.models.Language;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	List<Language> languages = new ArrayList<Language>();
	
	public List<Language> allLanguages(){
		return languages;
	}
	
	public Language findLanguageByIndex(int index) {
        if (index < languages.size()){
            return languages.get(index);
        }else{
            return null;
        }
    }
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public int findIndex(Language language) {
		return Arrays.asList(languages).indexOf(language);
	}
	public void destroyLanguage(int id) {
        if (id < languages.size()){
            languages.remove(id);
        }
    }
	public void updateLanguage(int index, Language language) {
		if(index<= languages.size()) {
			languages.set(index,  language);
		}
	}
}
