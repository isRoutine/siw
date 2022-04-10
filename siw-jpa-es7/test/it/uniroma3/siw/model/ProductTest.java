package it.uniroma3.siw.model;
  
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static Product p1;
	private static Product p2;
	
	@BeforeAll
	public static void BeforeAllTests() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		
		p1 = new Product();
		p1.setName("PRODUCT_ONE");
		p1.setDescription("first product...");

		p2 = new Product();
		p2.setName("PRODUCT_TWO");
		p2.setDescription("second product...");
	}
	
	@AfterAll
	public static void AfterAllTests() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}

	@BeforeEach
	public void BeforeEachTests() {
		
		Query deleteAll = em.createNamedQuery("deleteAllProducts");
		
		tx = em.getTransaction();
		tx.begin();
		em.persist(p1);
		em.persist(p2);
		tx.commit();
	}
	
	@Test
	public void getProduct() {
		TypedQuery<Product> findAll = em.createNamedQuery("findAllProducts",Product.class);
		List<Product> res = findAll.getResultList();
		assertEquals(2,res.size());	
	}


}


