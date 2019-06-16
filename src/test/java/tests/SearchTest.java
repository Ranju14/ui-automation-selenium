package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePageNSW;
import pages.SearchResultPage;
import utils.BaseClass;

public class SearchTest extends BaseClass {
		
	@DataProvider
	public Object[] SearchString(){
	  Object[] search = new Object[1];  
	  search[0] = "Apply for a number plate";
	  return search; 
	 }
	
	@Test(priority = 1,dataProvider="SearchString")
	public void searchItem(String searchItem) {
		HomePageNSW homePage = new HomePageNSW(driver);
		homePage.typeOnSearchBar(searchItem);
		homePage.clickOnSearchButton();
		SearchResultPage searchPage = new SearchResultPage(driver);
		searchPage.verifySearchResultPage(searchItem);

	}
	
}
