/**
 * 
 */
package com.manning.spock.pages;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manning.spock.model.Product;
import com.manning.spock.model.ProductList;

/**
 * 
 * The page where products are listed
 * 
 * @author kkapelonis
 * 
 */
@Controller
public class AddProductPage {

	private static final Logger logger = LoggerFactory.getLogger(AddProductPage.class);

	private ModelAndView mav = null;
	
	private ProductList productList = null;
	

	public AddProductPage() {
		mav = new ModelAndView();
		mav.setViewName("pages/add");
		mav.addObject("selectedTab", "welcome");
		mav.addObject("pageName", "Adding a new product");
	}

	@RequestMapping(value = "/add-product.html", method = RequestMethod.GET)
	public ModelAndView show() {
		prepare();
		return mav;
	}
	
	@RequestMapping(value = "/add-product.html", method = RequestMethod.POST, params={"productName","productPrice"})
	public ModelAndView apply(@RequestParam("productName") String productName,@RequestParam("productPrice") String productPrice) {
		
		if (!StringUtils.isNumeric(productPrice)) {
			mav.addObject("errors", "Price should be an integer. Sorry!");
			return show();
		}
		Product product = new Product();
		product.setName(productName);
		product.setWeight(0);
		product.setStock(0);
		product.setPrice(Integer.parseInt(productPrice));
		productList.getAllProducts().add(product);
		mav.addObject("success", "You added new product named: "+productName);
		prepare();

		return mav;
	}
	

	public void setProductList(ProductList productList) {
		this.productList = productList;
	}
	
	private void prepare() {
		mav.addObject("productName", "A product");
		mav.addObject("productPrice", 0);
	}
	
	
	
}
