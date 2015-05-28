package com.manning.spock.chapter6.mocks

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product
import com.manning.spock.chapter6.stubs.WarehouseInventory

class SimpleMockingSpec extends spock.lang.Specification{

	def "If the warehouse is empty nothing can be shipped"() {
		given: "a basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Basket basket = new Basket()
		
		and: "an empty warehouse"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		inventory.isEmpty() >> true
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv"
		basket.addProduct tv

		then: "order cannot be shipped"
		!basket.canShipCompletely()
	}
	
	def "credit card connection is always closed down"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")
		
		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out the tv"
		basket.addProduct tv
		basket.checkout(customer)

		then: "connection is always closed at the end"
		1 * creditCardSevice.shutdown()
	}
	

	
	
}

