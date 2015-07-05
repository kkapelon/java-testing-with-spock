/**
 * 
 */
package com.manning.spock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

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
	
	@RequestMapping(value = "/products", method = RequestMethod.DELETE)
	public String deleteAllProducts() {
		int count = existingProducts.size();
		existingProducts.clear();
		return "Removed "+count +" products";

	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public Product listProduct(@PathVariable Integer productId) {
		if(productId<0|| productId >= existingProducts.size())
		{
			throw new ProductNotFoundException("product id not found"); 
		}
		return existingProducts.get(productId);
	}
	
	@RequestMapping(value = "/products/{productId}/name", method = RequestMethod.PUT,params = "name")
	public Product renameProduct(@PathVariable Integer productId,@RequestParam("name") String name) {
		if(productId<0|| productId >= existingProducts.size())
		{
			throw new ProductNotFoundException("product id not found"); 
		}
		Product product = existingProducts.get(productId);
		product.setName(name);
		return product;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	private static  class ProductNotFoundException extends RuntimeException
	{       
	    private static final long serialVersionUID = 1L;    
	    public ProductNotFoundException(String message) {
	        super(message);
	    }    
	}

}
