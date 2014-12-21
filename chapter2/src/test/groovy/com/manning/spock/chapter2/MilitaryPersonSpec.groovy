package com.manning.spock.chapter2

import spock.lang.*

class MilitaryPersonSpec extends spock.lang.Specification{
	
	def "Testing getters and setters of a Java class"() {
		when: "a person has both first, last name and rank"
		MilitaryPerson person = new MilitaryPerson()
		person.firstName = "Susan"
		person.lastName = "Ivanova"
		person.setRank("Commander");

		then: "its title should be surname, name (rank)"
		person.createTitle() == "Ivanova, Susan (Commander)"
	}
	
}

