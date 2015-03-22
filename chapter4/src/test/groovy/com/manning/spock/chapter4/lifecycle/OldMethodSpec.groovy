package com.manning.spock.chapter4.lifecycle

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class OldMethodSpec extends spock.lang.Specification{

	def "Adding a second product to the basket increases its weight"() {
		given: "an empty basket"
		Basket basket = new Basket()
		
		and: "a tv is already added to the basket"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		basket.addProduct(tv)

		when: "user gets a camera too"
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		basket.addProduct(camera)

		then: "basket weight is updated accordingly"
		basket.currentWeight == old(basket.currentWeight) + camera.weight
	}

}

