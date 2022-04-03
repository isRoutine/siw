package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String titolo;
	
	private String descrizione;
	
	private LocalDate annoRealizzazione;

	@ManyToMany(mappedBy = "opere")
	private List<Artista> artisti;
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(LocalDate annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
