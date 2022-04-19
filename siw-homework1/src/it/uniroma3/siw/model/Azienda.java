package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Azienda {

	@Id
	private long id;
	
	private String ragioneSociale;
	
	private Indirizzo indirizzoSede;
	
	private String numeroDiTelefono;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Indirizzo getIndirizzoSede() {
		return indirizzoSede;
	}

	public void setIndirizzoSede(Indirizzo indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	
	
	
}
