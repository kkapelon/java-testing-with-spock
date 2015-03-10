package com.manning.spock.chapter4;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Basket {

	private Map<Product,Integer> contents = new HashMap<>();
	
	public void clearAllProducts()
	{
		contents.clear();
	}
	
	public void addProduct(Product product)
	{
		addProduct(product,1);
	}
	
	public void addProduct(Product product, int times)
	{
		if(contents.containsKey(product))
		{
			int existing = contents.get(product);
			contents.put(product,existing+times);
		}
		else
		{
			contents.put(product,times);
		}
	}
	
	public int getCurrentWeight()
	{
		int total = 0;
		for(Entry<Product,Integer> entry:contents.entrySet())
		{
			total = total + (entry.getKey().getWeight() * entry.getValue());
		}
		
		return total;
	}
	
	public int getProductTypesCount()
	{
		return contents.size();
	}
}
