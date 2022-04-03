package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curatore {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private int matricola;
	
	private String nomeMuseo;
	
	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNomeMuseo() {
		return nomeMuseo;
	}

	public void setNomeMuseo(String nomeMuseo) {
		this.nomeMuseo = nomeMuseo;
	}
	
}
