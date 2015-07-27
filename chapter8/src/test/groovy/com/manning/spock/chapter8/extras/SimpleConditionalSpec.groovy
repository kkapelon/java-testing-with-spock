package com.manning.spock.chapter8.extras

import spock.lang.*

import com.manning.spock.chapter8.eshop.BillableBasket
import com.manning.spock.chapter8.eshop.CreditCardProcessor
import com.manning.spock.chapter8.eshop.Customer
import com.manning.spock.chapter8.eshop.Product

class SimpleConditionalSpec extends spock.lang.Specification{

	@IgnoreIf({ jvm.java9 })
	def "credit card charge happy path"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = new CreditCardProcessor()
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out the tv"
		basket.addProduct tv
		boolean success = basket.checkout(customer)

		then: "credit card is charged"
		success

	}
	
	@IgnoreIf({ os.windows })
	def "credit card charge happy path - alt"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = new CreditCardProcessor()
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out the tv"
		basket.addProduct tv
		boolean success = basket.checkout(customer)

		then: "credit card is charged"
		success

	}
	
	@IgnoreIf({ env.containsKey("SKIP_SPOCK_TESTS") })
	def "credit card charge happy path - alt 2"() {
		given: "a basket, a customer and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		BillableBasket basket = new BillableBasket()
		Customer customer = new Customer(name:"John",vip:false,creditCard:"testCard")

		and: "a credit card service"
		CreditCardProcessor creditCardSevice = new CreditCardProcessor()
		basket.setCreditCardProcessor(creditCardSevice)

		when: "user checks out the tv"
		basket.addProduct tv
		boolean success = basket.checkout(customer)

		then: "credit card is charged"
		success

	}
	
}

