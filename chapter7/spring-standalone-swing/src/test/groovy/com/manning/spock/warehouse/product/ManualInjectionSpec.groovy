package com.manning.spock.warehouse.product

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.test.context.*

import spock.lang.*

class ManualInjectionSpec extends spock.lang.Specification{

	def "Testing hibernate mapping of product class - mem db"() {
		given: "the creation of a new product"
		ApplicationContext ctx = new ClassPathXmlApplicationContext("reduced-test-context.xml");
		ProductLoader productLoader = ctx.getBean(ProductLoader.class)

		when: "we read back that product"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "it should be present in the db"
		allProducts.size() == 0

	}
}

