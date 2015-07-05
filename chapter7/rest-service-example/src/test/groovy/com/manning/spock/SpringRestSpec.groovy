
package com.codepipes.wizard;

import org.springframework.web.client.RestTemplate

import spock.lang.*

/**
 * Rest tests using Spring Rest template
 * 
 * @author Kostis
 *
 */
@Stepwise
class SpringRestSpec extends Specification {

	def "Simple status checker"() {
		when: "a rest call is performed to the status page"
		RestTemplate restTemplate = new RestTemplate()
		String status = restTemplate.getForObject("http://localhost:8080/rest-service-example/status", String.class)
		
		then: "the correct message is expected"
		status == "Up and Running"
		
	}

	
}
