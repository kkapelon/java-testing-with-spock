package com.manning.spock.chapter4.structure;

import java.util.HashMap;
import java.util.Map;

import com.manning.spock.chapter4.Product;

public class WarehouseInventory {
	private int boxesMovedOut =0;
	
	protected Map<String,Integer> inventory = new HashMap<>();
	
	public void preload(Product product, int times)
	{
		inventory.put(product.getName(), times);
	}

	public void subtract(String productName, Integer times) {
		int now = inventory.get(productName);
		int after = now - times;
		if(after == 0)
		{
			inventory.remove(productName);
		}
		else
		{
			inventory.put(productName, after);
		}
		boxesMovedOut +=times;
		
		
	}
	
	public int availableOfProduct(String productName)
	{
		if(inventory.containsKey(productName))
		{
			return inventory.get(productName);
		}
		else
		{
			return 0;
		}
	}
	
	public boolean isEmpty()
	{
		return inventory.isEmpty();
	}
	
	public int getBoxesMovedToday()
	{
		return boxesMovedOut;
	}

}
