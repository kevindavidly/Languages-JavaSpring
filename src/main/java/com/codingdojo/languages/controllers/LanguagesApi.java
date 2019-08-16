package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
@RequestMapping("/api/languages")

public class LanguagesApi {
	@Autowired
	LanguageService languageService;
    
//  ----------------------------------------------------------------
//  show all
//  ----------------------------------------------------------------
	
    @RequestMapping("")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
//  ----------------------------------------------------------------
//  create
//  ----------------------------------------------------------------
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        Language language = new Language(name, creator, version);
        return languageService.createLanguage(language);
    }
    
//  ----------------------------------------------------------------
//  find by id
//  ----------------------------------------------------------------
    @RequestMapping("/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    
//  ----------------------------------------------------------------
//  edit
//  ----------------------------------------------------------------
    @PutMapping("/{id}")
    public Language update(@Valid Language language) {
		System.out.println(language.getCreatedAt());
        languageService.updateLanguage(language);
        return language;
    }
    
//  ----------------------------------------------------------------
//  delete
//  ----------------------------------------------------------------
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
    
}