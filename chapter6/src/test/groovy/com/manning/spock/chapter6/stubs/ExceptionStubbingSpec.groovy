package com.manning.spock.chapter6.stubs

import spock.lang.*

import com.manning.spock.chapter6.Basket
import com.manning.spock.chapter6.Product


class ExceptionStubbingSpec extends spock.lang.Specification{

	def "A problematic inventory means nothing can be shipped"() {
		given: "an basket, a TV and a camera"
		Product tv = new Product(name:"bravia",price:1200,weight:18)
		@Subject
				Basket basket = new Basket()

		and:"a warehouse with enough stock"
		WarehouseInventory inventory = Stub(WarehouseInventory)
		inventory.availableOfProduct( "bravia", _) >> { throw new RuntimeException("critical error") }
		basket.setWarehouseInventory(inventory)

		when: "user checks out the tv and the camera"
		basket.addProduct tv

		then: "order cannot be shipped"
		!basket.canShipCompletely()
	}
}

