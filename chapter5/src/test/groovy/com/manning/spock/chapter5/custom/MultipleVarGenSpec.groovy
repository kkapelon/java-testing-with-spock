package com.manning.spock.chapter5.custom

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator

class MultipleVarGenSpec extends spock.lang.Specification{

	
	@Unroll("Checking harcoded image name #pictureFile with #result")
	def "Valid images are PNG and JPEG files only"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()
		
		
		expect: "that all filenames are categorized correctly"
		validator.isValidImageExtension(pictureFile) == result
		
		where: "sample image names are"
		[pictureFile,result] << [["sample.jpg",true],
							     ["bunny.gif",false]]
	}
	
	
	@Unroll("Checking image name #pictureFile with result=#result")
	def "Valid images are PNG and JPEG files only 2"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()
		
		
		expect: "that all filenames are categorized correctly"
		validator.isValidImageExtension(pictureFile) == result
		
		where: "sample image names are"
		[pictureFile,result] << new MultiVarReader()
	}
	
	
}

