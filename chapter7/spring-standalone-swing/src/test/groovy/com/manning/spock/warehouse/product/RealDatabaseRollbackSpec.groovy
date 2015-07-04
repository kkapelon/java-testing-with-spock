package com.manning.spock.warehouse.product

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.*
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

import spock.lang.*

@ContextConfiguration(locations = "classpath:spring-context.xml")
@Transactional
class RealDatabaseRollbackSpec extends spock.lang.Specification{

	@Autowired
	ProductLoader productLoader

	@Rollback
	@Sql("clear-db.sql")
	def "Testing hibernate mapping of product class - rollback"() {
		given: "the creation of a new product"
		productLoader.createDefaultProduct()

		when: "we read back that product"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "it should be present in the db"
		allProducts.size() == 1

		and: "it should start with zero quantity"
		allProducts[0].stock ==0
	}
}

