package com.manning.spock.chapter2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spock.lang.*

/**
 * Spock demo quick object creation using map based constructors.
 * @author Kostis
 *
 */
class ObjectCreationSpec extends spock.lang.Specification{

	def "demo for quick constructors"() {
		when:
		Employee trainee = new Employee(age:22,firstName:"Alice",lastName:"Olson",inTraining:true)
		Employee seasoned = new Employee(middleName:"Jones",lastName:"Corwin",age:45,firstName:"Alex")
		
		List<Employee> people = Arrays.asList(trainee,seasoned)
		
		Department department = new Department()
		department.assign(people)

		then:
		department.manpowerCount() == 2
	}
	
	def "demo for quick constructors and lists"() {
		when:
		
		List<Employee> people = [
			new Employee(age:22,firstName:"Alice",lastName:"Olson",inTraining:true),
			new Employee(middleName:"Jones",lastName:"Corwin",age:45,firstName:"Alex")
			]
		
		Department department = new Department()
		department.assign(people)

		then:
		department.manpowerCount() == 2
	}
	
	
}

