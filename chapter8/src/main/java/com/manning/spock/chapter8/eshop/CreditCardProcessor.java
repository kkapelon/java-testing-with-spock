package com.manning.spock.chapter8.eshop;

public class CreditCardProcessor {

	public CreditCardResult sale(int amount, Customer customer){
		System.out.println("Charging "+amount);
		return CreditCardResult.OK;
	}
	
	public void shutdown(){
		System.out.println("Shutting down");
	}
	
	public boolean online()	{
		return true;
	}
}
