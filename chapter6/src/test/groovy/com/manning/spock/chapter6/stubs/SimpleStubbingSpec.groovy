package com.manning.spock.chapter6.stubs

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product

@Subject(Basket.class)
class SimpleStubbingSpec extends spock.lang.Specification{

	def "If warehouse is empty nothing can be shipped"() {
		given: "a basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Basket basket = new Basket()
		
		and:"an empty warehouse"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.isEmpty() >> true
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv"
		basket.addProduct tv

		then: "order cannot be shipped"
		!basket.canShipCompletely()
	}
	
	def "If warehouse has the product on stock everything is fine"() {
		given: "a basket and a TV"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Basket basket = new Basket()
		
		and:"a warehouse with enough stock"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.isProductAvailable("bravia",1) >> true
		inventory.isEmpty() >> false
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv"
		basket.addProduct tv

		then: "order can be shipped right away"
		basket.canShipCompletely()
	}
	
	def "If warehouse does not have all products, order cannot be shipped"() {
		given: "a basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()
		
		and:"a warehouse with partial availability"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.isProductAvailable("bravia",1) >> true
		inventory.isProductAvailable("panasonic",1) >> false
		inventory.isEmpty() >> false
		basket.setWarehouseInventory(inventory)

		when: "user checks out both products"
		basket.addProduct tv
		basket.addProduct camera

		then: "order cannot be shipped right away"
		!basket.canShipCompletely()
	}
	
	def "If warehouse does not have all products, order cannot be shipped (alt)"() {
		given: "a basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()
		
		and:"a warehouse with partial availability"
		WarehouseInventory inventory = Stub(WarehouseInventory) {
			isProductAvailable("bravia",1) >> true
			isProductAvailable("panasonic",1) >> false
			isEmpty() >> false
		}
		basket.warehouseInventory = inventory

		when: "user checks out both products"
		basket.addProduct tv
		basket.addProduct camera

		then: "order cannot be shipped right away"
		!basket.canShipCompletely()
	}
	
	
}

