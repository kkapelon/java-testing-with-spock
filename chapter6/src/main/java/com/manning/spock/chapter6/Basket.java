package com.manning.spock.chapter6;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.manning.spock.chapter6.stubs.WarehouseInventory;

public class Basket {

	private WarehouseInventory warehouseInventory;

	protected Map<Product, Integer> contents = new HashMap<>();

	public void clearAllProducts() {
		contents.clear();
	}

	public void addProduct(Product product) {
		addProduct(product, 1);
	}

	public void addProduct(Product product, int times) {
		if (contents.containsKey(product)) {
			int existing = contents.get(product);
			contents.put(product, existing + times);
		} else {
			contents.put(product, times);
		}
	}

	public int getCurrentWeight() {
		int total = 0;
		for (Entry<Product, Integer> entry : contents.entrySet()) {
			total = total + (entry.getKey().getWeight() * entry.getValue());
		}

		return total;
	}

	public int getProductTypesCount() {
		return contents.size();
	}

	public void setWarehouseInventory(WarehouseInventory warehouseInventory) {
		this.warehouseInventory = warehouseInventory;
	}

	public boolean canShipCompletely() {
		try {
			for (Entry<Product, Integer> entry : contents.entrySet()) {
				boolean ok = warehouseInventory.availableOfProduct(entry
						.getKey().getName(), entry.getValue());
				if (!ok) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
