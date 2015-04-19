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
			dailyDeal = special
			discountPercent = discount
		}
		customer.with
		{
			vip = isVip
			bonusPoints = points
		}
		currentOrder.totalPrice = order
		
		expect: "the proper discount"
		checkout.calculateDiscountPercentFor(product, currentOrder) == finalDiscount

		where: "some of the possible scenarios are"
		price | isVip | points | order | discount | special  || finalDiscount
		50    | false | 0      | 50    |      0   |  false   || 0
		100   | false | 0      | 300   |      0   |  false   || 10
		500   | false | 0      | 0     |      0   |  true    || 50
		50    | true  | 0      | 50    |      0   |  false   || 15
		50    | true  | 0      | 50    |      25  |  false   || 25
		50    | true  | 0      | 50    |      5   |  false   || 15
		50    | true  | 0      | 50    |      5   |  true    || 50
		50    | false | 0      | 100   |      0   |  false   || 0
		50    | false | 0      | 75    |      10  |  false   || 10
		50    | false | 5000   | 50    |      0   |  false   || 75
		50    | false | 3000   | 50    |      0   |  false   || 0
		50    | true  | 8000   | 50    |      3   |  false   || 75
	}
}

