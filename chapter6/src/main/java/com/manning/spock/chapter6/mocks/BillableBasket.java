package com.manning.spock.chapter6.mocks;

import java.util.Map.Entry;

import com.manning.spock.chapter6.Basket;
import com.manning.spock.chapter6.Product;

public class BillableBasket extends Basket{

	private CreditCardProcessor creditCardProcessor;

	public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
		this.creditCardProcessor = creditCardProcessor;
	}
	
	public void checkout(Customer customer)
	{
		creditCardProcessor.sale(findOrderPrice(), customer);
		creditCardProcessor.shutdown();
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
