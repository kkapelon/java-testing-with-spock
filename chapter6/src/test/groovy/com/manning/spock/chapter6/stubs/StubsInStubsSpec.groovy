package com.manning.spock.chapter6.stubs

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product

@Subject(Basket.class)
class StubsInStubsSpec extends spock.lang.Specification{

	def "If warehouse is empty nothing can be shipped"() {
		given: "a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		
		and:"an empty warehouse"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.isEmpty() >> true
		ServiceLocator serviceLocator = Stub(ServiceLocator)
		serviceLocator.getWarehouseInventory() >> inventory
		
		and: "a basket"
		EnterprisyBasket basket = new EnterprisyBasket(serviceLocator)
		
		when: "user checks out the tv"
		basket.addProduct tv

		then: "order cannot be shipped"
		!basket.canShipCompletely()
	}
	
	
	
}

