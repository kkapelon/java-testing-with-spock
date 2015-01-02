package com.manning.spock.chapter2

import spock.lang.*

class GroovyFilesSpec extends spock.lang.Specification{
	
	def "demo for reading a text file"() {
		when: "a paragraph is processed"
		WordDetector wordDetector = new WordDetector();
		String inputText = new File("src/test/resources/quotes.txt").text
		wordDetector.parseText(inputText); 

		then: "word frequency should be correct"
		wordDetector.wordsFound() == 78
		
	}
	
	def "demo for reading a text file line by line"() {
		when: "a paragraph is processed"
		List<String> inputText = new File("src/test/resources/quotes.txt").readLines()
		WordDetector wordDetector = new WordDetector();
		for(String line:inputText)
		{
			wordDetector.feedText(line)
		}

		then: "word count should be correct"
		wordDetector.wordsFound() == 78
	}
	
}

