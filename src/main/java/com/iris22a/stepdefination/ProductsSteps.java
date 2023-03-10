package com.iris22a.stepdefination;

import java.util.List;

import org.testng.Assert;

import com.iris22a.keywords.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTShirtsPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {

//	 This step is not required if @Before & @After- Hooks are used.. 
//	@Given("chrome browser is opened")
//	public void openBrowser() {
//		UIKeywords.openBrowser("Chrome");
//	}
	
	@And("url is launched")
	public void launchMyntraUrl() {
		UIKeywords.launchUrl(Environment.URL);
	}
	
	@When("user searches for polo t shirt")
	public void searchPoloTshirt() {
		HomePage home = new HomePage();
		home.searchProduct("Polo");
	}
	
	@Then("all results should be related to polo")
	public void verifyAllResults() {
		HomePage home = new HomePage();
		List<String>productTexts = home.getSearchResultTexts();
		for (String text : productTexts) {
			Assert.assertTrue(text.toLowerCase().contains("polo"),"product mismatch"+text);
		}
	}
	
	@When("user hovers on men menu")
	public void hoverOnMenMenu() {
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
	}
	
	@And("user clicks on men t-shirt")
	public void clickOnMenTShirt() {
		HomePage home = new HomePage();
		home.clickOnMenTShirt();
	}
	
	@Then("user selects popularity filter")
	public void selectPopularityFilter() {
		MenTShirtsPage menTShirt = new MenTShirtsPage();
		WaitFor.elementToBeClickable(menTShirt.sortByFilter);
		menTShirt.selectPopularityFilter();
	}
	
	
	
	
	
	
	
	
	
	
}
