package com.manning.spock.chapter4.blocks

import spock.lang.*

import com.manning.spock.chapter4.Basket
import com.manning.spock.chapter4.Product

class NoBlockSpec extends spock.lang.Specification{

	def "Invalid Spock test"() {
		int a = 5;
		a == 6;
	}
}

