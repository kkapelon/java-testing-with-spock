package com.manning.spock.warehouse.product

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.test.context.*

import spock.lang.*

class ManualInjectionSpec extends spock.lang.Specification{

	def "Testing hibernate mapping of product class - mem db"() {
		given: "a product DAO"
		ApplicationContext ctx = new ClassPathXmlApplicationContext("reduced-test-context.xml");
		ProductLoader productLoader = ctx.getBean(ProductLoader.class)

		when: "we read products from the DB"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "the db is empty"
		allProducts.size() == 0

	}
	
	def "Testing hibernate mapping of product class - mem db - no di at all"() {
		given: "a product DAO created programmatically without Spring"
		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:myDatabaseForUnitTests");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exampleFileBasedDatabase",properties);
		ProductLoader productLoader = new ProductLoader();
		EntityManager em = factory.createEntityManager()
		productLoader.setEm(em);

		when: "we initially read products from the DB"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "the db is empty"
		allProducts.size() == 0
		
		when: "we create one product"
		em.getTransaction().begin();
		productLoader.createDefaultProduct();
		em.getTransaction().commit();
		
		then: "the db should contain it if we read it again"
		productLoader.getAllProducts().size() == 1
		
		cleanup: "in the end close database"
		em.close()
		factory.close()

	}
}

