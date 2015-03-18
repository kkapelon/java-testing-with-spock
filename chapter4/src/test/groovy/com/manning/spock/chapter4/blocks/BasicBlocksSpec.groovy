package com.manning.spock.chapter4.blocks

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class BasicBlocksSpec extends spock.lang.Specification{

	def "Adding two and three results in 5"() {
		given: "the integers two and three"
		int a = 3
		int b = 2

		when: "they are added"
		int result = a + b

		then: "the result is five"
		result == 5
	}
}

