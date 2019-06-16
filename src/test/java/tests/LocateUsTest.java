package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePageNSW;
import pages.LocateUsPage;
import utils.BaseClass;


public class LocateUsTest extends BaseClass{
	
	@DataProvider
	 public Object[][] findServiceLocator(){
	
	  Object[][] locator = new Object[1][2];
	  
	  locator[0][0] = "Sydney 2000";
	  locator[0][1] = "Marrickville Service Centre";
	  
//	  locator[1][0] = "Sydney Domestic Airport 2020";
//	  locator[1][1] = "“Rockdale Service Centre”";
	  
	  return locator; 
	 }
	
	@Test(priority = 1,dataProvider="findServiceLocator")
	public void searchItem(String suburb, String serviceCenter) {
		HomePageNSW homePage = new HomePageNSW(driver);
		homePage.clickOnLocateUsButton();
		
		LocateUsPage locateUs = new LocateUsPage(driver);
		locateUs.typeOnLocationSearchBar(suburb);
		locateUs.clickOnLocationSearchIcon();
		locateUs.verifyLocateUsSearch(serviceCenter);
	}
		
}
