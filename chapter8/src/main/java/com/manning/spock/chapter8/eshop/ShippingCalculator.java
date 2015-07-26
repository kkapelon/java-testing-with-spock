package com.manning.spock.chapter8.eshop;


public interface ShippingCalculator {
	int findShippingCostFor(Product product, int times);
}
