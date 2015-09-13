package com.manning.spock.warehouse.product

import groovy.sql.Sql

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.*

import spock.lang.*

@ContextConfiguration(locations = "classpath:reduced-test-context.xml")
class DummyDatabaseGroovySqlWriteSpec extends spock.lang.Specification{
	@Autowired
	DataSource dataSource
	
	@Autowired
	ProductLoader productLoader

	def "Testing ordering of products"() {
		given: "the creation of 3 new products"
		Sql sql  = new Sql(dataSource)
		sql.execute("DELETE FROM PRODUCT")
		sql.execute("INSERT INTO PRODUCT (id,name,price, weight,stock) VALUES (1, 'samsung',400,1,45);")
		sql.execute("INSERT INTO PRODUCT (id,name,price, weight,stock) VALUES (2, 'bravia',1200,3,2);")
		sql.execute("INSERT INTO PRODUCT (id,name,price, weight,stock) VALUES (3, 'canon',500,5,23);")

		when: "we read back the products"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "they should be ordered by name"
		allProducts.size() == 3
		allProducts[0].name =="bravia"
		allProducts[1].name =="canon"
		allProducts[2].name =="samsung"
		
		cleanup: "remove inserted data"
		sql.execute("DELETE FROM PRODUCT")
		sql.close()
		
	}
	
	def "Testing ordering of products - improved"() {
		given: "the creation of 3 new products"
		Sql sql  = new Sql(dataSource)
		sql.execute("DELETE FROM PRODUCT")
		String insertProduct = "INSERT INTO PRODUCT (id,name,price, weight,stock) VALUES (?, ?,?,?,?);"
		sql.execute(insertProduct,[1, 'samsung',400,1,45])
		sql.execute(insertProduct,[2, 'bravia',1200,3,2])
		sql.execute(insertProduct,[3, 'canon',500,5,23])

		when: "we read back the products"
		List<Product> allProducts = productLoader.getAllProducts();

		then: "they should be ordered by name"
		allProducts.size() == 3
		allProducts[0].name =="bravia"
		allProducts[1].name =="canon"
		allProducts[2].name =="samsung"
		
		cleanup: "remove inserted data"
		sql.execute("DELETE FROM PRODUCT")
		sql.close()
	}
}

