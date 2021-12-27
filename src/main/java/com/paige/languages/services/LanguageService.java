package com.paige.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paige.languages.models.Language;
import com.paige.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language create(Language language) {
		 languageRepository.save(language);
		 return language;
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> language = languageRepository.findById(id);
		if (language.isPresent()){
			return language.get();
		}
		else {
			return null;
		}
	}
	
	public Language editLanguage(Language language){
		Optional<Language> optionalLanguage = languageRepository.findById(language.getId());
		if(optionalLanguage.isPresent()) {
			optionalLanguage.get().setName(language.getName());
			optionalLanguage.get().setCreator(language.getCreator());
			optionalLanguage.get().setCurrentVersion(language.getCurrentVersion());
			return languageRepository.save(optionalLanguage.get());
		}
		else {
			return null;
		}
		
	}
	
	public Long deleteLanguage(Long id) {
		 languageRepository.deleteById(id);
		 return id;
	}

}
