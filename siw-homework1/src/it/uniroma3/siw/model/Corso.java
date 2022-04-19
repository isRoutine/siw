package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Corso {

	@Id
	private long id;
	
	private String nome;

	private LocalDate dataInizio;
	
	private int mesi;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMesi() {
		return mesi;
	}

	public void setMesi(int mesi) {
		this.mesi = mesi;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	
}
