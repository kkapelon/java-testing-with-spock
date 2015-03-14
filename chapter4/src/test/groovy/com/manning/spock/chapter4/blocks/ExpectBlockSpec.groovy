package com.manning.spock.chapter4.blocks

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class ExpectBlockSpec extends spock.lang.Specification{

	def "A basket with two products weights as their sum (precondition)"() {
		given: "an empty basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()

		expect:"that nothing should be inside"
		basket.currentWeight == 0
		basket.productTypesCount == 0

		when: "user wants to buy the TV and the camera"
		basket.addProduct tv
		basket.addProduct camera

		then: "basket weight is equal to both camera and tv"
		basket.currentWeight == (tv.weight + camera.weight)
	}

	def "An empty basket has no weight (alternative)"() {
		given: "an empty basket"
		Basket basket = new Basket()

		expect: "that the weight is 0"
		basket.currentWeight == 0
	}


	def "An empty basket has no weight"() {
		expect: "zero weight when nothing is added"
		new Basket().currentWeight == 0
	}
}

