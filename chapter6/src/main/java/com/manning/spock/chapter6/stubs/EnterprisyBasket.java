package com.manning.spock.chapter6.stubs;

import com.manning.spock.chapter6.Basket;

public class EnterprisyBasket extends Basket{

	public EnterprisyBasket(ServiceLocator serviceLocator)
	{
		setWarehouseInventory(serviceLocator.getWarehouseInventory());
	}
}
