package com.services.nsw.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	 public static WebDriver driver = null;
	 
	//Page URL
	 private static String PAGE_URL="https://www.service.nsw.gov.au/";
	 
	 @BeforeSuite
		public void setup() throws Exception{
		 	// change "/Users/adarsh/Documents/Automation/gecko-driver" to "the path of geckodrive.exe in your PC"
			System.setProperty("webdriver.gecko.driver","/Users/adarsh/Documents/Automation/gecko-driver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(PAGE_URL);
	 }
	 
	 @AfterSuite
     public void tearDown() throws Exception { 
     driver.quit(); 
	 } 
}

