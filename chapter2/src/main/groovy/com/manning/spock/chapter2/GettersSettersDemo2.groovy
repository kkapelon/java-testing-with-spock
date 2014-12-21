package com.manning.spock.chapter2

class GettersSettersDemo2 {
	
	public static void main(String[] args)
	{
		Person person = new Person()
		person.firstName = "Marcus"
		person.lastName = "Cole"
		
		println("Person first name is "+person.firstName)
		println("Person last name is "+person.lastName)
	}
}
