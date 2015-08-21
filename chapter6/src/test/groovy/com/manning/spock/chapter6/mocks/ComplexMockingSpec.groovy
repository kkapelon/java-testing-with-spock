package com.manning.spock.chapter6.mocks

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product
import com.manning.spock.chapter6.stubs.WarehouseInventory

@Subject(BillableBasket.class)
class ComplexMockingSpec extends spock.lang.Specification{
	
	def "card has no funds"() {
		given: "a basket, a customer and some products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)
		
		and: "a fully stocked warehouse"
		WarehouseInventory inventory = Stub(WarehouseInventory)	{
			isProductAvailable(_ , _) >> true
			isEmpty() >> false
		}
		basket.setWarehouseInventory(inventory)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		boolean charged = basket.fullCheckout(customer)

		then: "nothing is charged if credit card does not have enough money"
		1 * creditCardSevice.authorize(1550, customer) >>  CreditCardResult.NOT_ENOUGH_FUNDS
		!charged
		0 * _
		
	}
	
	def "happy path for credit card sale"() {
		given: "a basket, a customer and some products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card that has enough funds"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)
		CreditCardResult sampleResult = CreditCardResult.OK
		sampleResult.setToken("sample");
		
		and: "a warehouse"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		basket.setWarehouseInventory(inventory)

		when: "user checks out two products"
		basket.addProduct tv
		basket.addProduct camera
		boolean charged = basket.fullCheckout(customer)

		then: "credit card is checked"
		1 * creditCardSevice.authorize(1550, customer) >>  sampleResult
		
		then: "inventory is checked"
		with(inventory) {
			2 * isProductAvailable(!null , 1) >> true
			_ * isEmpty() >> false
		}
		
		
		then: "credit card is charged"
		1 * creditCardSevice.capture({myToken -> myToken.endsWith("sample")}, customer) >>  CreditCardResult.OK
		charged
		0 * _
	}
	
	def "happy path for credit card sale - alternative"() {
		given: "a basket, a customer and some products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = Mock(CreditCardProcessor)
		basket.setCreditCardProcessor(creditCardSevice)
		
		and: "a warehouse"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv"
		basket.addProduct tv
		basket.addProduct camera
		boolean charged = basket.fullCheckout(customer)

		then: "credit card is checked"
		interaction {
			CreditCardResult sampleResult = CreditCardResult.OK
			sampleResult.setToken("sample");
			1 * creditCardSevice.authorize(1550, customer) >>  sampleResult
		}
		
		then: "inventory is checked"
		2 * inventory.isProductAvailable(!null , 1) >> true
		
		then: "credit card is charged"
		1 * creditCardSevice.capture({myToken -> myToken.endsWith("sample")}, customer) >>  CreditCardResult.OK
		charged
	}
	
	

	
}

