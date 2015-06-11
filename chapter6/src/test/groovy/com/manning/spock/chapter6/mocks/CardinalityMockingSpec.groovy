package com.manning.spock.chapter6.mocks

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product
import com.manning.spock.chapter6.stubs.ShippingCalculator;
import com.manning.spock.chapter6.stubs.WarehouseInventory

@Subject(Basket.class)
class CardinalityMockingSpec extends spock.lang.Specification{

	def "Warehouse is queried for each product"() {
		given: "a basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()
		
		and: "a warehouse with limitless stock"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		basket.setWarehouseInventory(inventory)

		when: "user checks out both products"
		basket.addProduct tv
		basket.addProduct camera
		boolean readyToShip = basket.canShipCompletely()

		then: "order can be shipped"
		readyToShip
		2 * inventory.isProductAvailable( _ , _) >> true
		0 * inventory.preload(_ , _)
	}
	
	def "Warehouse is queried for each product - strict"() {
		given: "a basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()
		
		and: "a warehouse with limitless stock"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		basket.setWarehouseInventory(inventory)

		when: "user checks out both products"
		basket.addProduct tv
		basket.addProduct camera
		boolean readyToShip = basket.canShipCompletely()

		then: "order can be shipped"
		readyToShip
		2 * inventory.isProductAvailable( _ , _) >> true
		1 * inventory.isEmpty() >> false
		0 * inventory._
	}
	
	def "Only warehouse is queried when checking shipping status"() {
		given: "a basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		Product camera = new Product(name:"panasonic",price:350,weight:2)
		Basket basket = new Basket()
		
		and: "a warehouse with limitless stock"
		WarehouseInventory inventory = Mock(WarehouseInventory)
		basket.setWarehouseInventory(inventory)
		ShippingCalculator shippingCalculator = Mock(ShippingCalculator)
		basket.setShippingCalculator(shippingCalculator)

		when: "user checks out both products"
		basket.addProduct tv
		basket.addProduct camera
		boolean readyToShip = basket.canShipCompletely()

		then: "order can be shipped"
		readyToShip
		2 * inventory.isProductAvailable( _ , _) >> true
		_ * inventory.isEmpty() >> false
		0 * _
	}
	
	
	

	
	
}

