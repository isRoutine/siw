package it.uniroma3.siw.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.siw.model.Product;

class ProductRepositoryTest {
	
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static ProductRepository pr;
	public static EntityTransaction tx;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		pr = new ProductRepository();
		pr.setEntityManager(em);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Product p1 = new Product("Prodotto A", (float) 1.0, "P_A", "A");
		Product p2 = new Product("Prodotto B", (float) 2.0, "P_B", "B");
		
		tx = em.getTransaction();
		tx.begin();
		pr.deleteAll();
		em.persist(p1);
		em.persist(p2);
		tx.commit();
	}

	@Test
	void findAllTest() {
		assertEquals(2,pr.findAll().size());
	}
	
	@Test
	void deleteAllTest() {
		tx = em.getTransaction();
		tx.begin();
		pr.deleteAll();
		tx.commit();
		assertEquals(0,pr.findAll().size());
	}
	
	@Test
	void countTest() {
		assertEquals(2,pr.count());
		Product p3 = new Product("Prodotto C", (float) 3.0, "P_C", "C");
		tx = em.getTransaction();
		tx.begin();
		em.persist(p3);
		tx.commit();
		assertEquals(3, pr.count());
		
		tx.begin();
		pr.delete(p3);
		tx.commit();
		assertEquals(2, pr.count());
	}

}
