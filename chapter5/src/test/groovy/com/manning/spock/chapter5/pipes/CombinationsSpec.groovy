package com.manning.spock.chapter5.pipes

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator
import com.manning.spock.chapter5.tables.Adder
import com.manning.spock.chapter5.tables.Calculator

@Unroll
class CombinationsSpec extends spock.lang.Specification{

	
	def "Adding two positive numbers results in a positive number as well"() {
		given: "an adder"
		Adder adder = new Adder()

		expect: "that it calculates the sum of two numbers"
		adder.add(first,second) > 0

		where: "some scenarios are"
		first << [14,45,78]
		second << [56,76,180]
	}
	
	def "Multipling #first and #second is always a negative number"() {
		given: "a calculator"
		Calculator calc = new Calculator()

		expect: "that multiplying a positive and negative number results in a negative number"
		calc.multiply(first,second) < 0

		where: "some scenarios are"
		first << (20..30)
		second << (-18..-8)
	}
	
	@Unroll("Checking image name #pictureFile")
	def "All kinds of JPEG file are accepted"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()
		
		expect: "that all jpeg filenames are accepted regarless of case"
		validator.isValidImageExtension(pictureFile)
		
		where: "sample image names are"
		pictureFile << [["sample.","Sample.","SAMPLE."],['j', 'J'], ['p', 'P'],['e',''],['g','G']].combinations()*.join()
	}
	
}

