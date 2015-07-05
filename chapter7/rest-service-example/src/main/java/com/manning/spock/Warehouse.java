/**
 * 
 */
package com.manning.spock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kkapelon
 *
 */
@RestController
public class Warehouse {
	
	private int counter =0;

	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String healthcheck() {
		counter++;
		return "Hello " +counter;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts() {
		counter++;
		return "Hello " +counter;
	}
	
//	@RequestMapping(value = "/vmname.html", method = RequestMethod.POST, params = "virtualmachinename")
//	public ModelAndView apply(@RequestParam("virtualmachinename") String virtualmachinename) {
//		if(StringUtils.isEmpty(virtualmachinename))
//		{
//			logger.debug("Empty name");
//			mav.addObject("errors", "Name cannot be empty");
//			prepare();
//			
//			return mav;
//		}
//		else
//		{
//			logger.debug("Saving VM name");
//			settings.setName(virtualmachinename);
//			return getNext().show();
//		}
//		
//	}
	
	
	
}
