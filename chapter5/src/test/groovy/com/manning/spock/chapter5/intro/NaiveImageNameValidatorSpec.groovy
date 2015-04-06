package com.manning.spock.chapter5.intro

import java.awt.image.ImageFilter;

import spock.lang.*


class NaiveImageNameValidatorSpec extends spock.lang.Specification{

	def "Valid images are JPG"() {
		given: "an image extension checker and a jpg file"
		ImageNameValidator validator = new ImageNameValidator()
		String pictureFile = "scenery.jpg"
		
		expect: "that the filename is valid"
		validator.isValidImageExtension(pictureFile)
	}
	
	def "Valid images are JPEG"() {
		given: "an image extension checker and a jpeg file"
		ImageNameValidator validator = new ImageNameValidator()
		String pictureFile = "house.jpg"
		
		expect: "that the filename is valid"
		validator.isValidImageExtension(pictureFile)
	}
	
	def "Valid images are PNG"() {
		given: "an image extension checker and a png file"
		ImageNameValidator validator = new ImageNameValidator()
		String pictureFile = "car.png"
		
		expect: "that the filename is valid"
		validator.isValidImageExtension(pictureFile)
	}
	
	def "Tiff are invalid"() {
		given: "an image extension checker and a tiff file"
		ImageNameValidator validator = new ImageNameValidator()
		String pictureFile = "sky.tiff"
		
		expect: "that the filename is invalid"
		!validator.isValidImageExtension(pictureFile)
	}
	
	def "Gif are invalid"() {
		given: "an image extension checker and a gif file"
		ImageNameValidator validator = new ImageNameValidator()
		String pictureFile = "dance_bunny.gif"
		
		expect: "that the filename is invalid"
		!validator.isValidImageExtension(pictureFile)
	}
	
	
}

