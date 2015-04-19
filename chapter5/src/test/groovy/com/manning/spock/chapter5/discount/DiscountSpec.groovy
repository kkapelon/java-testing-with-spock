package com.manning.spock.chapter5.discount

import java.awt.image.ImageFilter;

import spock.lang.*

class DiscountSpec extends spock.lang.Specification{

	def "Discount estimation for the eshop"() {
		given: "a product, a customer and an order"
		Product product = new Product()
		Customer customer = new Customer()
		Order currentOrder = new Order()
		Discount checkout = new Discount(customer)

		and: "several conditions that affect them"
		product.with {
			price = price
			dailyDeal = specialDeal
			discountPercent = discount
		}
		customer.with
		{
			vip = vipStatus
			bonusPoints = currentPoints
		}
		currentOrder.totalPrice = order
		
		expect: "the proper discount"
		checkout.calculateDiscountPercentFor(product, currentOrder) == finalDiscount

		where: "some of the possible scenarios are"
		price | vipStatus | currentPoints | order | discount | specialDeal  || finalDiscount
		50    | false     | 0             | 0     |      0   |   false      || 0
	}
}

