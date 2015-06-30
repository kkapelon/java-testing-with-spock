package com.manning.spock.warehouse.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductLoader {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Product product) {
		em.persist(product);
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> result = (List<Product>) em
				.createQuery(
						"select product from Product product order by product.name")
				.getResultList();
		return result;
	}
	
	public Product findById(Long productID)
	{
		return em.find(Product.class, productID);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Product update(Product product)
	{
		return em.merge(product);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long productID)
	{
		Product product = findById(productID);
	    if (product != null) {
	      em.remove(product);
	    }
	}
}
