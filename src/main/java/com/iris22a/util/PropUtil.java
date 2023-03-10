package com.iris22a.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.iris22a.pages.HomePage;

public class PropUtil {
	private static final Logger log = Logger.getLogger(PropUtil.class);
	
	public String getValue(String filePath ,String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			log.error("File not found: "+filePath);
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			log.error("Unable to load properties file: "+filePath);
		}
				return prop.getProperty(key);
	}

	/**
	 * This method can be used on OR.properties only
	 * @param key for which we want the locator 
	 * @return the locator value in the form of {@code String}
	 */
	public String[] getLocator(String key) {
		String baseDir = System.getProperty("user.dir");	// CWD (Current working directory) 
		return getValue(baseDir+"/src/main/resources/OR.properties", key).split("##");
	}
	
	
	
	
	
	
	
}
