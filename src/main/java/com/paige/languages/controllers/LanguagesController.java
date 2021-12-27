package com.paige.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.paige.languages.models.Language;
import com.paige.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public  LanguagesController(LanguageService languageService){
		this.languageService = languageService;
	}
	@RequestMapping("/")
	public String index(Model model){
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
//		this passes an empty Language "shell" or in other words a new empty instance to the model (aka jsp file) for our form to populate.
		model.addAttribute("language", new Language());
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/";
		}
		else {
			languageService.create(language);
			return "show.jsp";
		}
	}
	
	@RequestMapping("/language/{id}")
	public String show(@PathVariable("id") Long id, Model model){
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	

	
	@RequestMapping("/language/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	  @RequestMapping(value="/language/edit/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            languageService.editLanguage(language);
	            return "redirect:/";
	        }
	    }
	    
	
	@RequestMapping(value="/language/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id){
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
	 	
}
