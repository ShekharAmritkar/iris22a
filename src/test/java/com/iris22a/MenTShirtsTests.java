package com.iris22a;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTShirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

public class MenTShirtsTests extends TestBase {
	UIKeywords keyword = new UIKeywords();
	
	@Test
	public void verifyIfSearchByPopularityYieldsProperResults() {
		keyword.launchUrl(Environment.URL);
//		UIKeywords.launchUrl(Environment.URL);
		
//		UIKeywords.maximizeWindow();         // no need because maximize with chromeoptions....
		HomePage home = new HomePage(); 	// make object when required ten call method exctly below that.. dont make all objects at top/starting
		// Using pageFactory...for POM.
//		HomePage home = PageFactory.initElements(UIKeywords.driver, HomePage.class); 	
//		WaitFor.time(4);		// No need to use here just for creating the time method in WaitFor..
		home.hoverOnMenMenu();	
//		WaitFor.elementToBeClickable(home.menTShirt);	// No need to use here just for creating the method in WaitFor..
		home.clickOnMenTShirt();
		MenTShirtsPage menTShirt = new MenTShirtsPage();		// make object when required ten call method exctly below that.. dont make all objects at top
//		MenTShirtsPage menTShirt = PageFactory.initElements(UIKeywords.driver, MenTShirtsPage.class);
		WaitFor.elementToBeClickable(menTShirt.sortByFilter);
		menTShirt.selectPopularityFilter();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
