package com.manning.spock.chapter5.tables

import java.awt.image.ImageFilter;

import spock.lang.*

class MultiVariableSpec extends spock.lang.Specification{

	def "example with two results"() {
		given: "a calculator"
		Calculator calc = new Calculator()

		expect: "that it calculates the sum/product of two numbers"
		calc.add(first,second)==sum
		calc.multiply(first,second)==product

		where: "some scenarios are"
		first   |second     || sum  | product
		1       | 1         || 2    | 1
		3       | 2         || 5    | 6
		82      | 16        || 98   | 1312
		3       | -3        || 0    | -9
		0       | 0         || 0    | 0
	}
	
	
}

