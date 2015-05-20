package com.manning.spock.chapter6.stubs;

import com.manning.spock.chapter6.Product;

public interface ShippingCalculator {
	int findShippingCostFor(Product product, int times);
}
