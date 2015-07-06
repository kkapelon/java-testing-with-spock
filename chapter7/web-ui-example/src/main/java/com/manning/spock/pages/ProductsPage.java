/**
 * 
 */
package com.manning.spock.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manning.spock.model.ProductList;

/**
 * 
 * The page where products are listed
 * 
 * @author kkapelonis
 * 
 */
@Controller
public class ProductsPage {

	private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

	private ModelAndView mav = null;
	
	private ProductList productList = null;
	

	public ProductsPage() {
		mav = new ModelAndView();
		mav.setViewName("pages/products");
		mav.addObject("selectedTab", "welcome");
		mav.addObject("pageName", "Listing all products");
	}

	@RequestMapping(value = "/products.html", method = RequestMethod.GET)
	public ModelAndView index() {
		mav.addObject("allProducts",productList.getAllProducts());
		return mav;
	}

	public void setProductList(ProductList productList) {
		this.productList = productList;
	}
	
	
	
}
