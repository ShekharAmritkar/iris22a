package com.iris22a.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.iris22a.keywords.UIKeywords;

public class WaitFor {

	private static FluentWait<WebDriver>wait = null;
	
	static{
		wait =new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("wait is finished & element is not loaded or available");
	}
	
	public static void elementToBePresent(By locator) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void elementToBePresent(String lacatorType, String locatorValue) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.elementToBeClickable(UIKeywords.getWebElement(lacatorType, locatorValue)));
	}


	public static void elementToBeClickable(WebElement element) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public static void time(int durationInSeconds) {
		long stratTime = System.currentTimeMillis();
		long endTime = stratTime+(durationInSeconds*1000);
		while (stratTime<=endTime) {
			stratTime = System.currentTimeMillis();
		}
	}

		
	
	
	
	
	
	
	
}
