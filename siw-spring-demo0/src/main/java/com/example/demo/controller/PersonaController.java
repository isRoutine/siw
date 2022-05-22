package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.validator.PersonaValidator;
import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired 
	private PersonaService personaService;
	
	@Autowired 
	private PersonaValidator personaValidator;
	
	 
	/*
	 * Richieste al server:
	 * richieste get: il client chiede al server di leggere dati  (@GetMapping)
	 * richieste post: il client chiede al server di scrivere dati (@PostMapping)
	 * 
	 * Path:
	 * cerchiamo di usare path che corrispondo alle nostre classi del modello di dominio
	 * 
	 */

	

	/* Salvataggio di una persona
	 * - Uso il path generico /persona
	 * - Il type di ritorno String mi serve per ritornare la vista di mio interesse
	 */
	@PostMapping("/persona")
	public String addPersona(@Valid @ModelAttribute("persona") Persona persona, 
								BindingResult bindingResult, Model model) {
		
		personaValidator.validate(persona, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			personaService.save(persona);
			model.addAttribute("persona", persona);
			return "persona.html";
		}
		return "personaForm.html";
	}
	
	/* 
	 * Lettura di tutte le persone 
	 */
	@GetMapping("/persona")
	public String getPersone(Model model) {
		List<Persona> persone = personaService.findAll();
		model.addAttribute("persone", persone);
		return "persone.html";
	}
	
	
	/* 
	 * Lettura di una persona tramite id
	 */
	@GetMapping("/persona/{id}")
	public String getPersona(@PathVariable("id") Long id, Model model) {
		model.addAttribute("persona", this.personaService.findById(id));
		return "persona.html";
	}
	
	
	@GetMapping("/personaForm")
	public String getPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "personaForm.html";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletePersona(@PathVariable("id") Long id, Model model) {
		this.personaService.deleteById(id);
		return "persone.html";
	}

	@GetMapping("/edit/{id}")
	public String selectPersona(@PathVariable("id") Long id, Model model) {
		model.addAttribute("persona", this.personaService.findById(id));
		return "personaEditForm.html";
	}
	
	@PostMapping("/edit")
	public String editPersona(@Valid @ModelAttribute("persona") Persona persona,
									BindingResult bindingResult, Model model) {
		this.personaValidator.validate(persona, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.personaService.save(persona);
			List<Persona> persone = this.personaService.findAll();
			model.addAttribute("persone", persone);
			return "persone.html";
		}
		return "personaEditForm.html";
	}	
	
	
}
