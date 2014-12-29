package com.manning.spock.chapter2;

public class Employee {
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean retired;
	private boolean inTraining;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isRetired() {
		return retired;
	}
	public void setRetired(boolean retired) {
		this.retired = retired;
	}
	public boolean isInTraining() {
		return inTraining;
	}
	public void setInTraining(boolean inTraining) {
		this.inTraining = inTraining;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
