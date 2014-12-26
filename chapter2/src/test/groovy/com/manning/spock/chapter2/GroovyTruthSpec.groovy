package com.manning.spock.chapter2

import spock.lang.*

class GroovyTruthSpec extends spock.lang.Specification{
	
	def "demo for Groovy truth"() {
		when: "a line of text is processed"
		WordDetector wordDetector = new WordDetector();
		wordDetector.parseText("She sells sea shells over the sea shore"); 

		then: "word frequency should be correct"
		wordDetector.wordsFound() > 0
		wordDetector.duplicatesFound().size() > 0
		
		wordDetector.wordsFound()
		wordDetector.duplicatesFound()
	}
	
}

