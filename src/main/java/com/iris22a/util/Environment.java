package com.iris22a.util;

public class Environment {
	public static String filePath = "/src/main/resources/Environment.properties"; // use with static block only
//	String filePath = "/src/main/resources/Environment.properties";
	public static String URL;
	public static String BROWSER;

	// Url - using static block
	static {
		PropUtil prop = new PropUtil();
		String baseDir = System.getProperty("user.dir");
		URL = prop.getValue(baseDir+filePath, "app_url");
		BROWSER = prop.getValue(baseDir+filePath, "browser_name");
	}

	
	
//	// Url - using constructor
//	public Environment() {
//		PropUtil prop = new PropUtil();
//		String baseDir = System.getProperty("user.dir");
//		URL = prop.getValue(baseDir+filePath, "app_url");
//	}
	
	
//	// Url - using method
//	public String getAppUrl() {
//		PropUtil prop = new PropUtil();
//		String baseDir = System.getProperty("user.dir");
//		return prop.getValue(baseDir+filePath, "app_url");
//	}
	
	
	
	
}
