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
	private PersonaRepository pr;

	@Transactional // operazione transazionale, Spring si occupera della transazione
	public void save(Persona persona) {
		pr.save(persona);
	}
	
	// non necessaria la notazione @Transactional, sono metodi di lettura
	public Persona findById(Long id) {
		return pr.findById(id).get();
	}
	
	public List<Persona> findAll() {
		List<Persona> persone = new LinkedList<Persona>();
		for(Persona p : pr.findAll()) {
			persone.add(p);
		}
		return persone;	
	}
	
	
}