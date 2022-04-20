package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Indirizzo;

public class EnteFormazioneMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ente_formazione-unit");
		EntityManager em = emf.createEntityManager();
		
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setVia("Via Monti Simbruini");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(indirizzo);
		tx.commit();

		em.close();
		emf.close();
	}
}