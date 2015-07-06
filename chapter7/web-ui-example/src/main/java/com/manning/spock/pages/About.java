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

/**
 * The "technology" tab in the GUI
 * 
 * @author kkapelonis
 */
@Controller
public class About {

	private static final Logger logger = LoggerFactory.getLogger(About.class);

	private ModelAndView mav = null;
	

	public About() {
		mav = new ModelAndView();
		mav.setViewName("pages/about");
		mav.addObject("selectedTab", "about");
		mav.addObject("pageName", "Some Technical Notes");
	}

	@RequestMapping(value = "/about.html", method = RequestMethod.GET)
	public ModelAndView index() {
		logger.debug("About page is showing");
		return mav;
	}
	
}
