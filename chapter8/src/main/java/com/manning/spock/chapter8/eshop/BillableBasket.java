package com.manning.spock.chapter8.eshop;

import java.util.Map.Entry;

public class BillableBasket extends Basket{

	private CreditCardProcessor creditCardProcessor;

	public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
		this.creditCardProcessor = creditCardProcessor;
	}
	
	public boolean checkout(Customer customer)	{
		CreditCardResult result = creditCardProcessor.sale(findOrderPrice(), customer);
		
		return result == CreditCardResult.OK;
	}
	
	private int findOrderPrice() {
		int sum = 0;
		for (Entry<Product, Integer> entry : contents.entrySet()) {
			int count = entry.getValue();
			int price = entry.getKey().getPrice();
			sum = sum + (count * price);
		}
		return sum;
	}
	
}
