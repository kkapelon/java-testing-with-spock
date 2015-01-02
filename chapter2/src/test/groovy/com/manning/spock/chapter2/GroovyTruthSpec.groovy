package com.manning.spock.chapter2

import spock.lang.*

class GroovyTruthSpec extends spock.lang.Specification{
	
	def "demo for Groovy truth"() {
		when: "a line of text is processed"
		WordDetector wordDetector = new WordDetector();
		wordDetector.parseText("Understanding is a three edged sword: your side, their side, and the truth"); 

		then: "word frequency should be correct"
		wordDetector.wordsFound() > 0
		wordDetector.duplicatesFound().size() > 0
		
		wordDetector.wordsFound()
		wordDetector.duplicatesFound()
	}
	
	def "Another demo for Groovy multiline strings"() {
		when: "a paragraph is processed"
		String input = '''I want you to know you were right. I didn't want \
			to admit that. Just pride I guess. You get my age, you get kinda set in your \
			ways. It had to be done. Don't blame yourself for what happened later.'''
		WordDetector wordDetector = new WordDetector();
		wordDetector.parseText(input);

		then: "word count should be correct"
		wordDetector.wordsFound() == 34
	}
	
}

