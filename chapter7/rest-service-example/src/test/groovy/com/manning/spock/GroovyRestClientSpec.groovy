package com.manning.spock;

import groovyx.net.http.RESTClient
import spock.lang.*

/**
 * Rest tests using Groovy Rest client
 * 
 * @author Kostis
 *
 */
@Stepwise
class GroovyRestClientSpec extends Specification {
	
	@Shared
	def client = new RESTClient("http://localhost:8080/rest-service-example/")

	def "Simple status checker"() {
		when: "a rest call is performed to the status page"
		def response = client.get(path : "status")
		
		then: "the correct message is expected"
		with(response) {
			data.text == "Up and Running"
			status == 200
		}
	}
	
	def "Cleaning all products"() {
		given: "a rest call is performed that deletes everything"
		client.delete(path : "products")
		
		when: "a product list is requested"
		def response = client.get(path : "products")
		
		then: "it should be empty"
		with(response) {
			data.isEmpty()
			status == 200
		}
	}
	
	def "Creating a product"() {
		when: "a new product is created"
		def response = client.post(path : "products")
		
		and: "product list is requested again"
		def listResponse = client.get(path : "products")
		
		then: "it should have default values"
		with(response) {
			data.name == "A product"
			data.stock == 0
			data.price == 0
			status == 200
		}
		
		and: "product list should contain it"
		listResponse.data.size() == 1
	}

	
}
