package com.manning.spock.chapter4.structure

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class DoubleThenSpec extends spock.lang.Specification{

	def "Adding products to a basket increases its weight"() {
		given: "an empty basket"
		Basket basket = new Basket()
		
		and: "a two products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)

		when: "user gets the camera"
		basket.addProduct(camera)

		then: "basket weight is updated accordingly"
		basket.currentWeight == camera.weight
		
		when: "user gets the tv too"
		basket.addProduct(tv)

		then: "basket weight is updated accordingly"
		basket.currentWeight == camera.weight + tv.weight
	}

}

