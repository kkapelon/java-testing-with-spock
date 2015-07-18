package com.manning.spock.chapter5.pipes

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator
import com.manning.spock.chapter5.tables.Adder
import com.manning.spock.chapter5.tables.Calculator

@Unroll
class BasicPipesSpec extends spock.lang.Specification{

	
	def "Trivial adder test"() {
		given: "an adder"
		Adder adder = new Adder()

		expect: "that it calculates the sum of two numbers"
		adder.add(first,second) == sum

		where: "some scenarios are"
		first <<  [1, 3, 82,  3, 0]
		second << [1, 2, 16, -3, 0]
		sum <<    [2, 5, 98,  0, 0]
	}
	
	def "Valid images are PNG and JPEG files only"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator() 
	
		expect: "that only valid filenames are accepted"
		validator.isValidImageExtension(pictureFile) == validPicture 
	
		where: "sample image names are" 
		pictureFile  << ["scenery.jpg","house.jpeg", "car.png ","sky.tiff" ,"dance_bunny.gif" ]
		validPicture << [ true, true, false, false, false]
	}
	
	
	
	def "Multiplying  #first and #second is always a negative number"() {
		given: "a calculator"
		Calculator calc = new Calculator()

		expect: "that multiplying a positive and negative number is also negative"
		calc.multiply(first,second) < 0

		where: "some scenarios are"
		first << (20..80)
		second << (-65..-5)
	}
	
	@Unroll("Checking image name #pictureFile")
	def "All kinds of JPEG file are accepted"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()
		
		expect: "that all jpeg filenames are accepted regardless of case"
		validator.isValidImageExtension(pictureFile)
		
		where: "sample image names are"
		pictureFile << GroovyCollections.combinations([["sample.","Sample.","SAMPLE."],['j', 'J'], ['p', 'P'],['e','E',''],['g','G']])*.join()
	}
	
}

