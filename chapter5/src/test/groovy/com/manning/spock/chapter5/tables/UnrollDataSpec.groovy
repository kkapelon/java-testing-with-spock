package com.manning.spock.chapter5.tables

import java.awt.image.ImageFilter;

import spock.lang.*

class UnrollDataSpec extends spock.lang.Specification{

	@Unroll
	def "Trivial adder test"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when: "the add method is called for two numbers"
		int result = adder.add(first,second)

		then: "the result should be the sum of them"
		result ==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		3       | -3        || 0
	}
	
	@Unroll("Adder test #first, #second and  #sum (alt2)")
	def "Trivial adder test (alt2)"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when: "the add method is called for two numbers"
		int result = adder.add(first,second)

		then: "the result should be the sum of them"
		result ==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		3       | -3        || 0
	}
	
	@Unroll
	def "Adder test #first + #second = #sum (alt3)"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when: "the add method is called for two numbers"
		int result = adder.add(first,second)

		then: "the result should be the sum of them"
		result ==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		3       | -3        || 0
	}
	
}

