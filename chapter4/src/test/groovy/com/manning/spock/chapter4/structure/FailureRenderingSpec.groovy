package com.manning.spock.chapter4.structure

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class FailureRenderingSpec extends spock.lang.Specification{

	def "Adding products to a basket increases its weight"() {
		given: "an empty basket"
		Basket basket = new Basket()
//		Uncomment next line and comment the previous one in order to create a bug
//		ProblematicBasket basket = new ProblematicBasket()
		
		and: "two different products"
		Product laptop = new Product(name:"toshiba",price:1200,weight:5)
		Product camera = new Product(name:"panasonic",price:350,weight:2)

		when: "user gets a laptop and two cameras"
		basket.addProduct(camera,2)
		basket.addProduct(laptop)

		then: "basket weight is updated accordingly"
		basket.currentWeight == (2 * camera.weight) + laptop.weight
	}
	
	def "Adding products to a basket increases its weight (alt)"() {
		given: "an empty basket"
		Basket basket = new Basket()
//		Uncomment next line and comment the previous one in order to create a bug
//		ProblematicBasket basket = new ProblematicBasket()
		
		and: "a camera product"
		Product camera = new Product(name:"panasonic",price:350,weight:2)

		when: "user gets two cameras"
		basket.addProduct(camera,2)

		then: "basket weight is updated accordingly"
		assert basket.currentWeight == (2 * camera.weight) ,"Use case UC05 does not pass (critical)"
	}

}

