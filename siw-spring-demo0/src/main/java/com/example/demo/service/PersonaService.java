package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired // automatica viene creata una istanza di PersonaRepository 
	private PersonaRepository personaRepository;

	@Transactional // operazione transazionale, Spring si occupera della transazione
	public void save(Persona persona) {
		personaRepository.save(persona);
	}
	
	@Transactional
	public void update(Persona persona) {
		Persona foo = this.findById(persona.getId());
		foo.setNome(persona.getNome());
		foo.setCognome(persona.getCognome());
		foo.setEta(persona.getEta());
		this.personaRepository.save(foo);
	}
	
	@Transactional
	public void delete(Persona persona) {
		personaRepository.delete(persona);
	}
	
	@Transactional
	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}
	
	// non necessaria la notazione @Transactional, sono metodi di lettura
	public Persona findById(Long id) {
		return personaRepository.findById(id).get();
	}
	
	public List<Persona> findAll() {
		List<Persona> persone = new LinkedList<Persona>();
		for(Persona p : personaRepository.findAll()) {
			persone.add(p);
		}
		return persone;	
	}
	
	public boolean alreadyExist(Persona p) {
		return personaRepository.existsByNomeAndCognomeAndEta(p.getNome(), p.getCognome(), p.getEta());
	}
}
