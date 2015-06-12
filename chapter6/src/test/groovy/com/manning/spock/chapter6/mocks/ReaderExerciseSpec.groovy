package com.manning.spock.chapter6.mocks

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product
import com.manning.spock.chapter6.stubs.WarehouseInventory

@Subject(BillableBasket.class)
class ReaderExerciseSpec extends spock.lang.Specification{

	def "Nothing is charged if card becomes invalid after authorize"() {
		given: "a basket, a customer and some products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		and: "a fully stocked warehouse"
		WarehouseInventory inventory = Stub(WarehouseInventory) {
			isProductAvailable(_ , _) >> true
			isEmpty() >> false
		}
		basket.setWarehouseInventory(inventory)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		boolean charged = basket.fullCheckout(customer)

		then: "nothing is charged if credit card does not have enough money"
		1 * creditCardSevice.authorize(1550, customer) >>  CreditCardResult.OK
		1 * creditCardSevice.capture(_, customer) >>  CreditCardResult.INVALID_CARD
		!charged
		0 * _
	}

	def "Nothing is charged if stock is empty"() {
		given: "a basket, a customer and some products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		and: "an empty warehouse"
		WarehouseInventory inventory = Stub(WarehouseInventory) {
			isProductAvailable(_ , _) >> false
			isEmpty() >> true
		}
		basket.setWarehouseInventory(inventory)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		boolean charged = basket.fullCheckout(customer)

		then: "nothing is charged since inventory is empty"
		1 * creditCardSevice.authorize(1550, customer) 
		0 * creditCardSevice.capture(_,_) 
		!charged
		0 * _

		
	}
}

