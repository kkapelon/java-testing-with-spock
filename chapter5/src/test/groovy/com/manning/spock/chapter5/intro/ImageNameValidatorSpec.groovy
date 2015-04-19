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
	
	def "Valid images are PNG and JPEG files (enterprise version)"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()

		when: "an image is checked"
		ImageExtensionCheck imageExtensionCheck = validator.examineImageExtension(pictureFile)
		
		then: "expect that only valid filenames are accepted"
		imageExtensionCheck.result == validPicture
		imageExtensionCheck.errorCode == error
		imageExtensionCheck.errorDescription == description

		where: "sample image names are"
		pictureFile        || validPicture | error      | description
		"scenery.jpg"      || true         | ""         | ""
		"house.jpeg"       || true         | ""         | ""
		"car.png"          || true         | ""         | ""
		"sky.tiff"         || false        | "ERROR002" | "Tiff files are not supported"
		"dance_bunny.gif"  || false        | "ERROR999" | "Unsupported file type"
	}
	
	def "Valid images are PNG and JPEG files (grouped)"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()

		when: "an image is checked"
		ImageExtensionCheck imageExtensionCheck = validator.examineImageExtension(pictureFile)
		
		then: "expect that only valid filenames are accepted"
		with(imageExtensionCheck)
		{
			result == validPicture
			errorCode == error
			errorDescription == description
		}

		where: "sample image names are"
		pictureFile        || validPicture | error      | description
		"scenery.jpg"      || true         | ""         | ""
		"house.jpeg"       || true         | ""         | ""
		"car.png"          || true         | ""         | ""
		"sky.tiff"         || false        | "ERROR002" | "Tiff files are not supported"
		"dance_bunny.gif"  || false        | "ERROR999" | "Unsupported file type"
	}
}

