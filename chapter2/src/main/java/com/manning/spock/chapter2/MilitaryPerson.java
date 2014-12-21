package com.manning.spock.chapter2;

public class MilitaryPerson {
	private String firstName;
	private String lastName;
	private String rank;
	
	
	public String createTitle()
	{
		return lastName+", "+firstName +" ("+rank+")";
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
