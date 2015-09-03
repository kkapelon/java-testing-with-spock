package com.manning.spock.chapter8.loan;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private String name;
	private String address;
	private String city;
	private String phone;
	private Set<CreditCard> cards = new HashSet<>();
	
	private int activeLoans =0;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void requests(Loan loan)	{
		boolean result = true;
		if(getCards().size()>=3) {
			result = false;
		}
		if(loan.getAmount() > 500.000)	{
			result = false;
		}
		
		if(result)	{
			loan.getContactDetails().setAddress(getAddress());
			loan.getContactDetails().setCity(getCity());
			loan.getContactDetails().setName(getName());
			loan.getContactDetails().setPhone(getPhone());
			loan.setInstalments(12*loan.getYears());
			activeLoans++;
		}
		loan.setApproved(result);
	}
	
	public void owns(CreditCard creditCard) {
		cards.add(creditCard);
	}


	public Set<CreditCard> getCards() {
		return cards;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getActiveLoans() {
		return activeLoans;
	}


	public void setActiveLoans(int activeLoans) {
		this.activeLoans = activeLoans;
	}
	
	
	
	
	
	
}
