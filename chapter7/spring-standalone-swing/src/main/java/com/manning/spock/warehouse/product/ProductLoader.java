package com.manning.spock.warehouse.product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductLoader {
	@PersistenceContext
	private EntityManager em;
}
