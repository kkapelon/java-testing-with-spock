package com.manning.spock.chapter2

import spock.lang.*

class PersonSpec extends spock.lang.Specification{
	
	def "Testing getters and setters"() {
		when: "a person has both first name and last name"
		SimplePerson person = new SimplePerson()
		person.firstName = "Susan"
		person.lastName = "Ivanova"

		then: "its title should be surname, name"
		person.createTitle() == "Ivanova, Susan"
	}
	
}

class SimplePerson {
	String firstName
	String lastName
	
	String createTitle()
	{
		return "$lastName, $firstName"
	}
}