package com.manning.spock.warehouse.product

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.*
import org.springframework.test.jdbc.JdbcTestUtils
import org.springframework.transaction.annotation.Transactional

import spock.lang.*

@ContextConfiguration(locations = "classpath:reduced-test-context.xml")
@Transactional
class DummyDatabaseJdbcTemplateSpec extends spock.lang.Specification{
	JdbcTemplate jdbcTemplate;

	@Autowired
	void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	ProductLoader productLoader
	
	
	def "Testing hibernate mapping of product class - mem db"() {
		given: "the creation of a new product"
		productLoader.createDefaultProduct()

		expect: "it should be present in the db"
		JdbcTestUtils.countRowsInTable(this.jdbcTemplate, "product") == 1

		and: "it should start with zero quantity"
		JdbcTestUtils.countRowsInTableWhere(this.jdbcTemplate, "product","stock=0") == 1
	}
}

