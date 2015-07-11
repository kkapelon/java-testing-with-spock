package com.manning.spock.warehouse.product

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.test.context.*

import spock.lang.*

class ManualInjectionSpec extends spock.lang.Specification{

	def "Testing hibernate mapping of product class - mem db"() {
		given: "a product DAO"
		ApplicationContext ctx = new ClassPathXmlApplicationContext("reduced-test-context.xml");
		ProductLoader productLoader = ctx.getBean(ProductLoader.class)

		when: "we products from the DB"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "the db is empty"
		allProducts.size() == 0

	}
}

