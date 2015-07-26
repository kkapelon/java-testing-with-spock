package com.manning.spock.chapter8.eshop;

public class CreditCardProcessor {

	public CreditCardResult sale(int amount, Customer customer){
		return CreditCardResult.OK;
	}
	
	void shutdown(){
		
	}
}
