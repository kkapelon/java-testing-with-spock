package com.manning.spock.chapter4.blocks

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class AndBlockSpec extends spock.lang.Specification{

	def "A basket with three products weights as their sum"() {
		given: "an empty basket"
		Basket basket = new Basket()

		and: "several products"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Product hifi = new Product(name:"jvc",price:600,weight:5)

		when: "user wants to buy the TV and the camera and the hifi"
		basket.addProduct tv
		basket.addProduct camera
		basket.addProduct hifi

		then: "basket weight is equal to all product weight"
		basket.currentWeight == (tv.weight + camera.weight + hifi.weight)
	}

	def "A basket with three products weights as their sum (alternate)"() {
		given: "an empty basket, a TV,a camera and a hifi"
		Basket basket = new Basket()
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Product hifi = new Product(name:"jvc",price:600,weight:5)

		when: "user wants to buy the TV.."
		basket.addProduct tv

		and: "..the camera.."
		basket.addProduct camera

		and: "..and the wifi"
		basket.addProduct hifi

		then: "basket weight is equal to all product weight"
		basket.currentWeight == (tv.weight + camera.weight + hifi.weight)
	}

	def "A basket with three products has correct weight and count (controversial)"() {
		given: "an empty basket, a TV,a camera and a hifi"
		Basket basket = new Basket()
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Product hifi = new Product(name:"jvc",price:600,weight:5)

		when: "user wants to buy the TV and the camera and the hifi"
		basket.addProduct tv
		basket.addProduct camera
		basket.addProduct hifi

		then: "the basket weight is equal to all product weights"
		basket.currentWeight == (tv.weight + camera.weight + hifi.weight)

		and: "it contains 3 products"
		basket.productTypesCount == 3
	}
}

