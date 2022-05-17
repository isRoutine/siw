package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Persona;

// 													   Class Type, Class id
public interface PersonaRepository extends CrudRepository<Persona, Long> {

	public boolean existsByNomeAndCognomeAndEta(String nome, String cognome, Integer eta);
}
