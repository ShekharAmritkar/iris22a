package com.iris22a.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.iris22a.keywords.UIKeywords;

public class CasualShirtsPage {

	// without using pageFactory...
	public By itemCount = By.xpath("//span[@class='title-count']");
	
	public int getItemCount() {
		String itemCount =UIKeywords.driver.findElement(this.itemCount).getText();
		// getting string in output so, extracting only numbers from them...
		Pattern p = Pattern.compile("//d");
		Matcher m = p.matcher(itemCount);
		String count = m.group();
		return Integer.parseInt(count);
	}
	
	
	
	
	
	
}
