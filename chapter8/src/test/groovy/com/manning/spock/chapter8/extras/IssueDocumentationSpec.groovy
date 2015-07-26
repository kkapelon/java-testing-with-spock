package com.manning.spock.chapter8.extras

import spock.lang.*

import com.manning.spock.chapter8.eshop.Product
import com.manning.spock.chapter8.eshop.WarehouseInventory

class IssueDocumentationSpec extends spock.lang.Specification{

	@Issue("JIRA-561")
	def "Error conditions for unknown products"() {
		given: "a warehouse"
		WarehouseInventory inventory = new WarehouseInventory()

		when: "warehouse is queried for the wrong product"
		inventory.isProductAvailable("productThatDoesNotExist",1) 

		then: "an exception should be thrown"
		thrown(IllegalArgumentException)
	}
	
	@Issue("http://redmine.example.com/issues/2554")
	def "Error conditions for unknown products - better"() {
		given: "a warehouse"
		WarehouseInventory inventory = new WarehouseInventory()

		when: "warehouse is queried for the wrong product"
		inventory.isProductAvailable("productThatDoesNotExist",1)

		then: "an exception should be thrown"
		IllegalArgumentException e = thrown()
		e.getMessage() == "Uknown product productThatDoesNotExist"
	}
	
	@Issue(["JIRA-453","JIRA-678","JIRA-3485"])
	def "Negative quantity is the same as 0"() {
		given: "a warehouse"
		WarehouseInventory inventory = new WarehouseInventory()
		
		and: "a product"
		Product tv = new Product(name:"bravia",price:1200,weight:18)

		when: "warehouse is loaded with a negative value"
		inventory.preload(tv,-5)

		then: "the stock is empty for that product"
		notThrown(IllegalArgumentException)
		!inventory.isProductAvailable(tv.getName(),1)
	}
}

