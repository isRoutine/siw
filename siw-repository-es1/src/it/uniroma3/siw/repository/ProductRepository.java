package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Product;

public class ProductRepository {

	private EntityManager em;
	
	
	public Product save(Product product) {
		if(product.getId() != null)
			em.merge(product);
		else 
			em.persist(product);
		return product;
	}

	
	public Product findBy(Long id) {
		return em.find(Product.class, id);
	}
	
	
	public List<Product> findAll(){
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}
	
	public void delete(Product product) {
		em.remove(product);
	}
	
	public void deleteAll() {
		em.createQuery("delete from Product").executeUpdate();
	}
	
	
	public long count() {
		return (long)em.createQuery("select count(id) from Product").getSingleResult(); 
	}
	
	
	public boolean existsById(long id) {
		return this.findBy(id)!= null;
	}
	
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
