/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver

driver = { new FirefoxDriver() }

baseUrl = "http://localhost:9081"
reportsDir = "target/geb-reports"