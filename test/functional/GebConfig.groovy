/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

baseUrl = 'http://localhost:8080/stats-web/'

// Use htmlunit as the default
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
	def d = new HtmlUnitDriver()
	d.javascriptEnabled = false
	d
}

environments {
	
	// run as “grails -Dgeb.env=chrome test-app”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run as “grails -Dgeb.env=firefox test-app”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

}
