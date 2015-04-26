package com.manning.spock.chapter5.tables

import spock.lang.*

import com.manning.spock.chapter5.intro.ImageNameValidator

class SingleColumnSpec extends spock.lang.Specification{

	def "Tiff, gif, raw,mov and bmp are invalid extensions (orig)"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()

		expect: "that only valid filenames are accepted"
		validator.isValidImageExtension(pictureFile) == validPicture

		where: "sample image names are"
		pictureFile        || validPicture
		"screenshot.bmp"   || false
		"IMG3434.raw"      || false
		"christmas.mov"    || false
		"sky.tiff"         || false
		"dance_bunny.gif"  || false
	}
	
	def "Tiff, gif, raw,mov and bmp are invalid extensions"() {
		given: "an image extension checker"
		ImageNameValidator validator = new ImageNameValidator()

		expect: "that only valid filenames are accepted"
		!validator.isValidImageExtension(pictureFile)

		where: "sample image names are"
		pictureFile        || _
		"screenshot.bmp"   || _
		"IMG3434.raw"      || _
		"christmas.mov"    || _
		"sky.tiff"         || _
		"dance_bunny.gif"  || _
	}
}

