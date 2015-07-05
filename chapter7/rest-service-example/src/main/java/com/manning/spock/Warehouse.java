/**
 * 
 */
package com.manning.spock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kkapelon
 *
 */
@RestController
public class Warehouse {

	private List<Product> existingProducts = new ArrayList<Product>();

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String healthcheck() {
		return "Up and Running";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> listProducts() {
		return existingProducts;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createDefaultProduct() {
		Product product = new Product();
		product.setName("A product");
		product.setPrice(0);
		product.setStock(0);
		product.setWeight(0);
		product.setId(existingProducts.size());
		existingProducts.add(product);

		return product;

	}

}
