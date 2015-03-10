package com.manning.spock.chapter4

import spock.lang.*

class BasketWeightSpec extends spock.lang.Specification{
	
	
	
	def "A basket with one product has equal weight"() {
		given: "an empty basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Basket basket = new Basket()
		
		when: "user wants to buy the TV"
		basket.addProduct(tv)

		then: "basket weight is equal to the TV"
		basket.currentWeight == tv.weight
	}
	
	
	def "A basket with two products weights as their sum"() {
		given: "an empty basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		@Subject
		Basket basket = new Basket()
		
		when: "user wants to buy the TV and the camera"
		basket.addProduct tv
		basket.addProduct camera

		then: "basket weight is equal to both camera and tv"
		basket.currentWeight == (tv.weight + camera.weight)
	}
	
	def "A basket with two products weights as their sum (alternative)"() {
		setup: "an empty basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		@Subject
		Basket basket = new Basket()
		
		when: "user wants to buy the TV and the camera"
		basket.addProduct tv
		basket.addProduct camera

		then: "basket weight is equal to both camera and tv"
		basket.currentWeight == (tv.weight + camera.weight)
	}
	
	def "A basket with two products weights as their sum (precondition)"() {
		given: "an empty basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		@Subject
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
	
	def "A basket with three products weights as their sum"() {
		given: "an empty basket, a TV,a camera and a hifi"
		@Subject
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
		@Subject
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
		@Subject
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

