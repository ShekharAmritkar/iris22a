package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeywords;

public class MenTShirtsPage {

	@FindBy(xpath = "//div[@class=\\\"sort-sortBy\"]")
	public WebElement sortByFilter;
	@FindBy(xpath = "//h4[normalize-space()='Country of Origin']")
	public WebElement countryOfOrigin;
	@FindBy(xpath = "//li//*[contains(text(),'Popularity')]")
	public WebElement popularityFilter;

	// Initializing by pageFactory using constructor
	public MenTShirtsPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}
	
	// Initialization done in constructor is one approach... but don't use this
//	public MenTShirtsPage() {
//		sortByFilter = UIKeywords.driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
//		countryOfOrigin = UIKeywords.driver.findElement(By.xpath("//h4[normalize-space()='Country of Origin']"));
//		popularityFilter = UIKeywords.driver.findElement(By.xpath("//li//*[contains(text(),'Popularity')]"));
//	}
	
	public void clickOnSortByFilter() {
		sortByFilter.click();
	}
	
	public void selectPopularityFilter() {
		UIKeywords.mouseMove(sortByFilter);
		UIKeywords.click(popularityFilter);
	}
	
	
	
	
	
	
	
	
	
	
	
}
