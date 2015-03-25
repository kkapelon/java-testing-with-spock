package com.manning.spock.chapter4.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.manning.spock.chapter4.Product;

public class ProblematicBasket {

	protected Map<Product,Integer> contents = new HashMap<>();
	
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
		//Bug always add one product regardless of times
		if(contents.containsKey(product))
		{
			int existing = contents.get(product);
			contents.put(product,existing);
		}
		else
		{
			contents.put(product,1);
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
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder("[ ");
		for (Entry<Product, Integer> entry:contents.entrySet())
		{
			builder.append(entry.getValue());
			builder.append(" x ");
			builder.append(entry.getKey().getName());
			builder.append(", ");
		}
		builder.setLength(builder.length()-2);
		
		return builder.append(" ]").toString();
	}
	
	
	
	
}
