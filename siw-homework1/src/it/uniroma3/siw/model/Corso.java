package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;

	private LocalDate dataInizio;
	
	private int mesi;
	
	// imposto una politica di fetch di tipo eager
	// se sto analizzando un corso, molto probabilmente
	// la cosa che mi interessa maggiormente sono i partecipanti
	// un po' come avevamo visto per order e orderline
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Allievo> allievi;
	
	@ManyToOne
	private Docente docente;
	
	
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
