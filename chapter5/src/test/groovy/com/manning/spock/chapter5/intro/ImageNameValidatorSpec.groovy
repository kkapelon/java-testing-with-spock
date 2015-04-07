package com.manning.spock.chapter5.intro

import java.awt.image.ImageFilter;

import spock.lang.*

class ImageNameValidatorSpec extends spock.lang.Specification{

	def "Valid images are PNG and JPEG files"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()

		expect: "that only valid filenames are accepted"
		validator.isValidImageExtension(pictureFile) == validPicture

		where: "sample image names are"
		pictureFile        || validPicture
		"scenery.jpg"      || true
		"house.jpeg"       || true
		"car.png"          || true
		"sky.tiff"         || false
		"dance_bunny.gif"  || false
	}
}

