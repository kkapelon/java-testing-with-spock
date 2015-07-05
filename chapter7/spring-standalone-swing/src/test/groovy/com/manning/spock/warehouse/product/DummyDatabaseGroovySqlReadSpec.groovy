package com.manning.spock.warehouse.product

import groovy.sql.Sql

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.*
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction
import org.springframework.transaction.annotation.Transactional;

import spock.lang.*

@ContextConfiguration(locations = "classpath:reduced-test-context.xml")
class DummyDatabaseGroovySqlReadSpec extends spock.lang.Specification{
	@Autowired
	DataSource dataSource

	@Autowired
	ProductLoader productLoader

	def "Negative values should be never allowed in the Database"() {
		given: "an invalid product"
		Product product = new Product(name:'samsung',weight:-2,stock:-4,price:-400)
		Sql sql  = new Sql(dataSource)


		when: "this product is sent to the db"
		Product saved = productLoader.update(product)

		then: "all negative values should be zero"
		sql.rows("SELECT * FROM product") == [[ID:saved.getId(), NAME:'samsung', PRICE:0, STOCK:0, WEIGHT:0]]
	}
}

