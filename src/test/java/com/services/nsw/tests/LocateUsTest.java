package com.services.nsw.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.services.nsw.pages.HomePageNSW;
import com.services.nsw.pages.LocateUsPage;
import com.services.nsw.utils.BaseClass;

public class LocateUsTest extends BaseClass{
	
	@DataProvider
	 public Object[][] findServiceLocator(){
		
	  Object[][] locator = new Object[1][2];
	  locator[0][0] = "Sydney 2000";
	  locator[0][1] = "Marrickville Service Centre";
	  return locator; 
	 }
	
	@Test(priority = 1,dataProvider="findServiceLocator")
	public void searchItem(String suburb, String serviceCenter) {
		
		HomePageNSW homePage = new HomePageNSW(driver);
		homePage.clickOnLocateUs();
		
		LocateUsPage locateUs = new LocateUsPage(driver);
		locateUs.typeOnLocationSearchBar(suburb);
		locateUs.verifyLocateUsSearch(serviceCenter);
		
	}	
}
