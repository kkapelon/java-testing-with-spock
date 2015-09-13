
package com.manning.spock;

import geb.Browser
import geb.spock.GebSpec
import spock.lang.*

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
			go "/web-ui-example/add-product.html"
		}
		
		then: "the form should load"
		$(".col1").$("h2").text() == "New Product details"
	}
	
	def "Creation of new product"() {
		when: "I fill in product details"
		$("input[name='productName']").value("Bravia TV")
		$("#createProductButton").click()
		
		then: "I should see a success message"
		$(".ok").text() == "You added new product named: Bravia TV."
	}

	
}
