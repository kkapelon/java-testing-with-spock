package com.manning.spock.chapter5.custom

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator

class DataIteratorsSpec extends spock.lang.Specification{
	
	@Unroll("Checking image name #pictureFile")
	def "Valid images are PNG and JPEG files"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()


		expect: "that all filenames are rejected"
		!validator.isValidImageExtension(pictureFile)

		where: "sample image names are"
		pictureFile << new InvalidNamesGen()
	}
}

