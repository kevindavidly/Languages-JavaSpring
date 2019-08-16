package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;

//---------------------------------------------------------------------------------------------
// returns all
//---------------------------------------------------------------------------------------------
	
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
//---------------------------------------------------------------------------------------------
// creates
//---------------------------------------------------------------------------------------------

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    
//---------------------------------------------------------------------------------------------
// gets one by id
//---------------------------------------------------------------------------------------------
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
//---------------------------------------------------------------------------------------------
// updates
//---------------------------------------------------------------------------------------------
    
    public void updateLanguage(@Valid Language language) {
    	languageRepository.save(language);
    	
    }
    
//---------------------------------------------------------------------------------------------
// deletes
//---------------------------------------------------------------------------------------------
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    	
    }
}