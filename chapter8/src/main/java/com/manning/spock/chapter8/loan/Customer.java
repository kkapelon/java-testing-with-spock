package com.manning.spock.chapter8.loan;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private String name;
	private Set<CreditCard> cards = new HashSet<>();
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void requests(Loan loan)
	{
		boolean result = false;
		if(getCards().size()>=3)
		{
			result = false;
		}
		
		loan.setApproved(result);
	}
	
	public void owns(CreditCard creditCard)
	{
		cards.add(creditCard);
	}


	public Set<CreditCard> getCards() {
		return cards;
	}
	
	
}
