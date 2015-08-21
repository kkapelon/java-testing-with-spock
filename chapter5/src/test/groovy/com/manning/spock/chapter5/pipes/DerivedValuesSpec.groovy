package com.manning.spock.chapter5.pipes

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator
import com.manning.spock.chapter5.tables.Adder
import com.manning.spock.chapter5.tables.Calculator

@Unroll
class DerivedValuesSpec extends spock.lang.Specification{
	
	
	def "Multipling #first and #second is always a negative number"() {
		given: "a calculator"
		Calculator calc = new Calculator()

		expect: "that multiplying a positive and negative number results in a negative number"
		calc.multiply(first,second) < 0

		where: "some scenarios are"
		first << [20,34,44,67]
		second = -1
	}
	
	def "Multipling #first and #second is always a negative number (alt)"() {
		given: "a calculator"
		Calculator calc = new Calculator()

		expect: "that multiplying a positive and negative number results in a negative number"
		calc.multiply(first,second) < 0

		where: "some scenarios are"
		first << [20,34,44,67]
		second = first * -1
	}
	
	
	
}

