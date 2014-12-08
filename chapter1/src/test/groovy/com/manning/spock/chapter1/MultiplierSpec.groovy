package com.manning.spock.chapter1

import spock.lang.*

class MultiplierSpec extends spock.lang.Specification{
	def "Multiply two numbers and return the result"() {
		when: "a new Multiplier class is created"
		def multi = new Multiplier();

		then: "3 times 7 is 21"
		multi.multiply(3, 7) == 21
	}
	
	def "Combine both multiplication and addition"() {
		when: "a new Multiplier and Adder classes are created"
		def adder = new Adder();
		def multi = new Multiplier()

		then: "4 times (2 plus 3) is 20"
		multi.multiply(4, adder.add(2, 3)) == 20
		
		and: "(2 plus 3) times 4 is also 20"
		multi.multiply(adder.add(2, 3),4) == 20
		
	}
}
