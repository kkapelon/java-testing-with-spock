package com.manning.spock.chapter4.lifecycle;

import java.util.Map.Entry;

import com.manning.spock.chapter4.Basket;
import com.manning.spock.chapter4.Product;

public class BillableBasket extends Basket {

	private CreditCardProcessor creditCardProcessor;

	public BillableBasket() {
//		System.out.println("BillableBasket is starting");
	}

	public void checkout() {
		if (creditCardProcessor == null) {
			return;
		}
		int total = 0;
		for (Entry<Product, Integer> entry : contents.entrySet()) {
			total = total + (entry.getKey().getPrice() * entry.getValue());
		}
		creditCardProcessor.charge(total);
	}

	public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
		this.creditCardProcessor = creditCardProcessor;
	}

	
}
