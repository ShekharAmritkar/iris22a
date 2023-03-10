package com.iris22a.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keywords.UIKeywords;
import com.iris22a.pages.HomePage;

public class TestBase {
	private static final Logger log = Logger.getLogger(TestBase.class);
	
	@Parameters("browser-name")
	@BeforeMethod
	public void setUp(@Optional String browserName) throws Exception {
		if (browserName==null) {
			browserName = "chrome";
	}
		if (browserName.isEmpty()) {
			browserName = "chrome";
			log.info("Setting default browser as chrome");
		}
		UIKeywords.openBrowser(browserName);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		UIKeywords.closeBrowser();
	}
	
	
	
	
	
}
