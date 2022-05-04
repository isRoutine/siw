package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.Indirizzo;

public class EnteFormazioneMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ente_formazione-unit");
		EntityManager em = emf.createEntityManager();
		
		Indirizzo indirizzo = new Indirizzo("Via Della Vasca Navale", "59", "Roma", "00000", "Roma");	
		Azienda azienda = new Azienda();
		azienda.setRagioneSociale("Ferrari spa");
		azienda.setIndirizzoSede(indirizzo);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(azienda);
		tx.commit();

		em.close();
		emf.close();
	}
}