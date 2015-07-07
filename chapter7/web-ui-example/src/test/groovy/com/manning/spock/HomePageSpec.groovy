package com.manning.spock;

import geb.spock.GebSpec
import spock.lang.*
import geb.spock.GebReportingSpec
import geb.Browser

/**
 * Trivial Geb test
 * @author Kostis
 *
 */
class HomePageSpec extends GebSpec {

	def "Trivial Geb test for homepage"() {
		when: "I go to homepage"
		Browser.drive {
			go "http://localhost:8080/web-ui-example/index.html"
		}
		
		then: "First page should load"
		Browser.drive {
			// make sure we actually got to the page
			title == "Spock/Geb Web example"
		}
		
	}
	
	def "Trivial Geb test for homepage -header check"() {
		when: "I go to homepage"
		Browser.drive {
			go "http://localhost:8080/web-ui-example/index.html"
		}
		
		then: "First page should load"
		Browser.drive {
			// make sure we actually got to the page
			title == "Spock/Geb Web example"
			$("h1").text() == "Java Testing with Spock - Sample code"
			$(".active").text() == "Welcome"
		}
		
	}

	
}
