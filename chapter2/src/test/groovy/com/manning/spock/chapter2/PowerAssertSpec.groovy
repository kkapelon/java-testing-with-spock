package com.manning.spock.chapter2

import spock.lang.*

/**
 * Spock demo for failed assertion.
 * Remove the Ignore annotation to make the test run
 * @author Kostis
 *
 */
@Ignore
class PowerAssertSpec extends spock.lang.Specification{

	def "Demo for Spock assert numbers"() {
		expect:
		(4 * 15) - (24 / 3) == ( 2 * 30 ) - 9
	}

	def "demo for Spock assert strings"() {
		when:
		String quote = "Please scan Abbut. Report to me his thoughts at present"

		then:
		quote =="Please scan Abut. Report to me his thoughts at present"
	}
	
	def "demo for Spock assert lists"() {
		when:
		List<String> all = ["Vorlon","Shadows","Minbari", "Humans","Drazi"]
		List<String> firstOnes = ["Vorlon","Shadows"]

		then:
		all.subList(0, all.indexOf("Humans")) == firstOnes
	}
	
	def "demo for Spock assert calls"() {
		when:
		String text = "They are alone. They are a dying race."
		WordDetector wordDetector = new WordDetector()
		

		then:
		wordDetector.feedText(text).duplicatesFound().size() == 5
	}
}

