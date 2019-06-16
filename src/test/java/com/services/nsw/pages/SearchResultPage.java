package com.services.nsw.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.services.nsw.utils.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(className = "search__title")
	private WebElement searchResultHeading;
	
	public SearchResultPage(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void verifySearchResultPage(String searchText) {
		 WebDriverWait wait= new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
		 String searchResult = searchResultHeading.getText();
		 assertTrue(searchResult.contains(searchText));
	}
}
