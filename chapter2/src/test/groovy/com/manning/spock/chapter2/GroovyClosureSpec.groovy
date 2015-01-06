package com.manning.spock.chapter2

import spock.lang.*

class GroovyClosureSpec extends spock.lang.Specification{
	
	def "Testing Jpeg files"() {
		when: "only jpeg files are selected from a list of filenames"
		FileExtensionFilter myFilter = new FileExtensionFilter()
		myFilter.addValidExtension("jpeg")
		myFilter.addValidExtension("jpg")
		
		List<String> testInput = ["image1.jpg","image2.png","image3.jpeg","image4.gif","image5.jpg","image6.tiff"]
		List<String> result = myFilter.filterFileNames(testInput)

		then: "result should not contain other types"
		result.every{ filename -> filename.endsWith("jpeg") || filename.endsWith("jpg")} 
	}
	
}

