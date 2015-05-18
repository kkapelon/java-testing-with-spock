package com.manning.spock.chapter6.stubs

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product

@Subject(Basket.class)
class ArgumentStubbingSpec extends spock.lang.Specification{

	
	def "If warehouse is fully stocked stock everything is fine"() {
		given: "an basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Basket basket = new Basket()
		
		and:"a warehouse with enough stock"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.availableOfProduct(_,1) >> true
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv"
		basket.addProduct tv

		then: "order can be shipped right away"
		basket.canShipCompletely()
	}
	
	
	
	
}

