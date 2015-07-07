
package com.manning.spock;

import geb.spock.GebSpec
import spock.lang.*
import geb.spock.GebReportingSpec
import geb.Browser

/**
 * Adding a new product interactively
 * @author Kostis
 *
 */
@Stepwise
class AddProductGebSpec extends GebSpec {

	def "Navigation to page"() {
		when: "I go to the new product page"
		Browser.drive {
			go "http://localhost:8080/web-ui-example/add-product.html"
		}
		
		then: "the form should load"
		$(".col1").$("h2").text() == "New Product details"
	}
	
	def "Creation of new product"() {
		when: "I fill in product details"
		$("#createProductButton").click()
		
		then: "I should see a success message"
		$(".ok").text() == "You added new product named: A product."
	}

	
}
