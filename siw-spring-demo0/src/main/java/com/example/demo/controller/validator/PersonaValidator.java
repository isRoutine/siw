package com.example.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@Component
public class PersonaValidator implements Validator {
	
	@Autowired
	private PersonaService ps;

	@Override
	public boolean supports(Class<?> clazz) {
		return Persona.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(ps.alreadyExist((Persona)target)) {
			errors.reject("persona.duplicato");
		}
			
	}

}
