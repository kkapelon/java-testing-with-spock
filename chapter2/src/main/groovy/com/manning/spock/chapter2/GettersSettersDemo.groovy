package com.manning.spock.chapter2

class GettersSettersDemo {
	
	public static void main(String[] args)
	{
		Person person = new Person()
		person.setFirstName("Lyta")
		person.setLastName("Alexander")
		
		System.out.println("Person first name is "+person.getFirstName())
		System.out.println("Person last name is "+person.getLastName())
	}
}
