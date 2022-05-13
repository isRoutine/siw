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

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService ps;
	 
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
		if(!bindingResult.hasErrors()) {
			this.ps.save(persona);
			model.addAttribute("persona", this.ps.findById(persona.getId()));
			return "persona.html";
		}
		return "personaForm.html";
	}
	
	/* 
	 * Lettura di tutte le persone 
	 */
	@GetMapping("/persona")
	public String getPersone(Model model) {
		List<Persona> persone = ps.findAll();
		model.addAttribute("persone", persone);
		return "persone.html";
	}
	
	
	/* 
	 * Lettura di una persona tramite id
	 */
	@GetMapping("/persona/{id}")
	public String getPersona(@PathVariable("id") Long id, Model model) {
		model.addAttribute("persona", this.ps.findById(id));
		return null;
	}
	
	
	@GetMapping("/personaForm")
	public String getPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "personaForm.html";
	}
	
}
