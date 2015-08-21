package com.manning.spock.chapter4.lifecycle

import spock.lang.*

import com.manning.spock.chapter4.Product

class SharedSpec extends spock.lang.Specification{

	
	@Shared
	CreditCardProcessor creditCardProcessor;
	
	BillableBasket basket
	
	def setupSpec() {
		creditCardProcessor = new CreditCardProcessor()
	}     
	
	def setup() {
		basket = new BillableBasket()
		creditCardProcessor.newDayStarted()
		basket.setCreditCardProcessor(creditCardProcessor)
	}         
	
	def "user buys a single product"() {
		given: "an empty basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		
		and: "user wants to buy the TV"
		basket.addProduct(tv)
		
		when: "user checks out"
		basket.checkout()

		then: "revenue is the same as the price of TV"
		creditCardProcessor.currentRevenue == tv.price
	}
	
	

	def "user buys two products"() {
		given: "an empty basket and a camera"
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		
		and: "user wants to two cameras"
		basket.addProduct(camera,2)
		
		when: "user checks out"
		basket.checkout()

		then: "revenue is the same as the price of both products"
		creditCardProcessor.currentRevenue == 2 * camera.price
	}
	
	
	def cleanup() {
		basket.clearAllProducts()
	}        
	
	def cleanupSpec() {
		creditCardProcessor.shutDown()
	}   

	
}

