package com.manning.spock.chapter5.tables

import java.awt.image.ImageFilter;

import spock.lang.*

class LifecycleDataSpec extends spock.lang.Specification{

	def "Trivial adder test"() {
		given: "an adder"
		Adder adder = new Adder()
//		println "Given: block runs"
		
		when:"the add method is called for two numbers"
		int result = adder.add(first,second)
//		println "When: block runs for $first and $second"

		then: "the result should be the sum of them"
		result ==sum
//		println "Then: block is evaluated for $sum"

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		3       | -3        || 0
	}
	
	@Unroll
	def "Trivial adder test (alt)"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when:"the add method is called for two numbers"
		int result = adder.add(first,second)

		then: "the result should be the sum of them"
		result ==sum

		where: "some scenarios are"
		first   |second     || sum
		1       | 1         || 2
		3       | 2         || 5
		3       | -3        || 0
	}
	
	
	
	@Unroll("Adder test #first, #second, #sum (alt2)")
	def "Trivial adder test (alt3)"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when:"the add method is called for two numbers"
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
	def "Adder test #first, #second, #sum (alt3)"() {
		given: "an adder"
		Adder adder = new Adder()
		
		when:"the add method is called for two numbers"
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

