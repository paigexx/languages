package com.paige.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paige.languages.models.Language;
import com.paige.languages.services.LanguageService;

@RestController
public class LanguagesAPI {
	private final LanguageService languageService;
	public LanguagesAPI(LanguageService languageService) {
		this.languageService = languageService;
	}
//	get all languages
	@RequestMapping("/api/languages")
	public List<Language> index(){
		return languageService.allLanguages();
	}

}
