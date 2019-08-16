package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;



@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	
//---------------------------------------------------------------------------------------------
// get all 
//---------------------------------------------------------------------------------------------

		@GetMapping("")
	    public String index(@ModelAttribute("newLanguage") Language language, Model model) {
	        List<Language> languages = languageService.allLanguages();
	        model.addAttribute("languages", languages);
	        return "/languages/index.jsp";
	    }
		
//---------------------------------------------------------------------------------------------
// route to render new page 
//---------------------------------------------------------------------------------------------
		
//		@GetMapping("/new")
//	    public String newLanguage(@ModelAttribute("newLanguage") Language language) {
//	        return "/languages/new.jsp";
//	    }
	
//---------------------------------------------------------------------------------------------
// route to add
//---------------------------------------------------------------------------------------------
		
	    @PostMapping(value="")
	    public String create(@Valid @ModelAttribute("newLanguage") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/index.jsp";
	        } else {
	            languageService.createLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
//---------------------------------------------------------------------------------------------
// get to show by id
//---------------------------------------------------------------------------------------------
	    
	    @GetMapping("/{id}")
	    public String showLanguage(Model model, @PathVariable("id") Long id) {
	    	Language language = languageService.findLanguage(id);
	    	model.addAttribute("language", language);
	    	return "/languages/show.jsp";
	    }
	    
//---------------------------------------------------------------------------------------------
// route to render edit page 
//---------------------------------------------------------------------------------------------
	    
	    @GetMapping("/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/languages/edit.jsp";
	    }
	    
//---------------------------------------------------------------------------------------------
// route to update 
//---------------------------------------------------------------------------------------------
	    
	    @PutMapping("/{id}")
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/edit.jsp";
	        } else {
	            languageService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
//---------------------------------------------------------------------------------------------
// route to delete
//---------------------------------------------------------------------------------------------
	    
	    @DeleteMapping("/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }
}