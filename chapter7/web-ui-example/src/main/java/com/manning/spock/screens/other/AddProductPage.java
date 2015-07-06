/**
 * 
 */
package com.manning.spock.screens.other;

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
public class AddProductPage {

	private static final Logger logger = LoggerFactory.getLogger(AddProductPage.class);

	private ModelAndView mav = null;
	
	private ProductList productList = null;
	

	public AddProductPage() {
		mav = new ModelAndView();
		mav.setViewName("other/add");
		mav.addObject("selectedTab", "welcome");
		mav.addObject("pageName", "Adding a new product");
	}

	@RequestMapping(value = "/add-product.html", method = RequestMethod.GET)
	public ModelAndView index() {
		logger.debug("Welcome page is showing");
		return mav;
	}

	public void setProductList(ProductList productList) {
		this.productList = productList;
	}
	
	
	
}
