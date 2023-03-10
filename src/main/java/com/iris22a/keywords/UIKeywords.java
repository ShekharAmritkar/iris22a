package com.iris22a.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iris22a.pages.HomePage;
/**
 * 
 * @author SHEKHAR
 *
 */
public class UIKeywords {
		public static RemoteWebDriver driver;
		private static final Logger log = Logger.getLogger(UIKeywords.class);
		
	public static void openBrowser(String browserName) {
			if(browserName.equalsIgnoreCase("Chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications","--start-maximized");
				driver = new ChromeDriver(option);
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} 		
			log.info(browserName+"browser is launched successfully");
	}
	
	public static void launchUrl(String url) {
			driver.get(url);
			log.info("Url is launched"+url);
	}	
	
	public static void closeBrowser() {
			driver.close();
			log.info("Browser is closed successfully");
	}
	
	public static void maximizeWindow() {
			driver.manage().window().maximize();
	}
	
	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if(driver.switchTo().window(window).getTitle().equals(byTitle)) {
				log.info("Switched on window"+byTitle);
				break;
			}
		}
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}
	
	public static void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public static void enterText(WebElement element, String productName) {
		element.sendKeys(productName);
	}
	
	public static void hitButton(int keyCode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			log.error("unable to instantiate Robot class instance");
		}
				robo.keyPress(keyCode);
				robo.keyRelease(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<WebElement> elements = getWebElements(locatorType, locatorValue);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}
	
	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();
	}

	public static void mouseMove(String locatorType, String locaterValue) {
		Actions act = new Actions(UIKeywords.driver);
		act.moveToElement(getWebElement(locatorType, locaterValue)).perform();
	}	
	
	public static void mouseMove(WebElement element) {
		Actions act = new Actions(UIKeywords.driver);
		act.moveToElement(element).perform();
	}
	
	public static void click(By xpath) {
		driver.findElement(xpath).click();
	}
	
	public static void click(String locatorType, String locaterValue) {
		getWebElement(locatorType, locaterValue).click();
	}
	
	public static void click(WebElement element) {
		element.click();
	}

	public static WebElement getWebElement(String locatorType, String locaterValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element=driver.findElement(By.xpath(locaterValue));
		}else if (locatorType.equalsIgnoreCase("id")) {
			element=driver.findElement(By.id(locaterValue));
		}else if (locatorType.equalsIgnoreCase("name")) {
			element=driver.findElement(By.name(locaterValue));
		}else if (locatorType.equalsIgnoreCase("className")) {
			element=driver.findElement(By.className(locaterValue));
		}else if (locatorType.equalsIgnoreCase("tagName")) {
			element=driver.findElement(By.tagName(locaterValue));
		}else if (locatorType.equalsIgnoreCase("linkText")) {
			element=driver.findElement(By.linkText(locaterValue));
		}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element=driver.findElement(By.partialLinkText(locaterValue));
		}else if (locatorType.equalsIgnoreCase("cssSelector")) {
			element=driver.findElement(By.cssSelector(locaterValue));
		}else {
			log.error("Invalid locator type");
		}
		return element;
	}

	public static List<WebElement> getWebElements(String locatorType, String locaterValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements=driver.findElements(By.xpath(locaterValue));
		}else if (locatorType.equalsIgnoreCase("id")) {
			elements=driver.findElements(By.id(locaterValue));
		}else if (locatorType.equalsIgnoreCase("name")) {
			elements=driver.findElements(By.name(locaterValue));
		}else if (locatorType.equalsIgnoreCase("className")) {
			elements=driver.findElements(By.className(locaterValue));
		}else if (locatorType.equalsIgnoreCase("tagName")) {
			elements=driver.findElements(By.tagName(locaterValue));
		}else if (locatorType.equalsIgnoreCase("linkText")) {
			elements=driver.findElements(By.linkText(locaterValue));
		}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			elements=driver.findElements(By.partialLinkText(locaterValue));
		}else if (locatorType.equalsIgnoreCase("cssSelector")) {
			elements=driver.findElements(By.cssSelector(locaterValue));
		}else {
			log.error("Invalid locator type");
		}
		return elements;
	}

	

	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
}
