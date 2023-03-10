package com.iris22a.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keywords.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Cucumber_TestBase {
	private static final Logger log = Logger.getLogger(Cucumber_TestBase.class);

	// There are 2 approaches in Cucumber for launching browser
	// First one- Make browser in Environment file & take here from env...
	// Second- Most popular--> We can pass argument at the runtime in maven build
	//command--> clean install -DbrowserName=Chrome
	
	
	@Before
	public void setUp() throws Exception {
		// This line required for command line passing & same variable(brwsrName) should be pass below itself...
		String brwsrName = System.getProperty("browserName");  
		String browserName = Environment.BROWSER;  // This is not required if passing through command line....
		if (browserName==null) {
			browserName = "chrome";
	}
		if (browserName.isEmpty()) {
			browserName = "chrome";
			log.info("Setting default browser as chrome");
		}
		UIKeywords.openBrowser(browserName);
	}
	
	@After
	public void tearDown() throws Exception {
		UIKeywords.closeBrowser();
	}
	
	
	
	
	
}
