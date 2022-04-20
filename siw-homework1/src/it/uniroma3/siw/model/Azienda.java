package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Azienda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String ragioneSociale;
	
	// in caso di persist/remove di un oggetto Azienda, ha senso 
	// che sia automaticamente fatta una persist/remove sul suo 
	// indirizzo perche' e' strettamente legato
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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
