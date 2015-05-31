package com.manning.spock.chapter6.mocks

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product
import com.manning.spock.chapter6.stubs.WarehouseInventory

@Subject(BillableBasket.class)
class ArgumentVerificationSpec extends spock.lang.Specification{

	def "vip status is correctly passed to credit card - simple"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		basket.checkout(customer)

		then: "credit card is charged"
		1 * creditCardSevice.sale(1550, customer)
	}
	
	def "vip status is correctly passed to credit card - vip"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		basket.checkout(customer)

		then: "credit card is charged"
		1 * creditCardSevice.sale(1550, { client -> client.vip == false})
	}
	
	def "vip status is correctly passed to credit card - full"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		basket.checkout(customer)

		then: "credit card is charged"
		1 * creditCardSevice.sale({amount -> amount == basket.findOrderPrice()}, { client -> client.vip == false})
	}


	
}

