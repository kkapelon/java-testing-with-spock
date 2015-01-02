package com.manning.spock.chapter2

class Person2 {
	String firstName
	String lastName
	int age
	String rank
}

Person2 person = new Person2()
person.firstName = "Susan"
person.lastName = "Ivanova"
person.rank = "Commander"

println "Person first name is $person.firstName"
println "Person last name is $person.lastName"
println "Person rank is $person.rank"


person.with 
{
	assert firstName == "Susan"
	assert lastName == "Ivanova"
	assert rank == "Commander"
}
