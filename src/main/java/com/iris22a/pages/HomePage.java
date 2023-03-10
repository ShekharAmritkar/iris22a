package com.iris22a.pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.iris22a.keywords.UIKeywords;

public class HomePage {
	
	private static final Logger log = Logger.getLogger(HomePage.class);
	
	// @CacheLookup - It will look first in cache, if not found then only go to DOM... so Time will save.... 
	@CacheLookup				
	@FindBy(xpath = "//div[@class=\"desktop-navLink\"]/a[@href='/shop/men']")
	public WebElement menMenu;
	@CacheLookup
	@FindBy(xpath = "//a[@href='/men-tshirts']")
	public WebElement menTShirt;
	@FindBy(xpath = "//a[@href=\"/men-casual-shirts\"]")
	public WebElement casualShirt;
	@FindBy(css = "input[placeholder='Search for products, brands and more']")
	public WebElement searchComponent;
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTexts;
	
	
	// Initializing by pageFactory using constructor
	public HomePage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}
	
	
	// Initialization done in constructor is one approach... but don't use this  
//	public HomePage() {
//		menMenu = UIKeywords.driver.findElement(By.xpath("//div[@class=\"desktop-navLink\"]/a[@href=\"/shop/men\"]"));
//		menTShirt = UIKeywords.driver.findElement(By.xpath("//a[@href='/men-tshirts']"));
//	}
	
	
	
	public void hoverOnMenMenu() {
		UIKeywords.mouseMove(menMenu);
	}
	
	public void clickOnMenTShirt() {
		UIKeywords.click(menTShirt);
	}

	public void clickOnCasualShirts() {
		UIKeywords.click(casualShirt);
		log.info("clicked on casual shirts");
	}

	public void searchProduct(String productName) {
			UIKeywords.enterText(searchComponent, productName);
			UIKeywords.hitButton(KeyEvent.VK_ENTER);
	}
	
	public List<String> getSearchResultTexts() {
		List<String>productTexts = new ArrayList<String>();
		
		for (WebElement product : this.productTexts) {
			productTexts.add(product.getText());
		}
		return productTexts;
	}
	
	
	
	
	
	
	
	
	
}
