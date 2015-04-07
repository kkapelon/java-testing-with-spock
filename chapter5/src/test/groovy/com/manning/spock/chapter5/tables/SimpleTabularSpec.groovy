package com.manning.spock.chapter5.tables

import java.awt.image.ImageFilter;

import spock.lang.*

class SimpleTabularSpec extends spock.lang.Specification{

	def "Trivial adder test"() {
		given: "an adder"
		Adder adder = new Adder()

		expect: "that it calculates the sum of two numbers"
		adder.add(first,second)==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		82      | 16        || 98
		3       | -3        || 0
		0       | 0         || 0
	}
	
	def "Trivial adder test (alt)"(int first, int second, int sum) {
		given: "an adder"
		Adder adder = new Adder()

		expect: "that it calculates the sum of two numbers"
		adder.add(first,second)==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		82      | 16        || 98
		3       | -3        || 0
		0       | 0         || 0
	}
}

