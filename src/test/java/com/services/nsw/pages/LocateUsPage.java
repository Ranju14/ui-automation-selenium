package com.services.nsw.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.services.nsw.utils.BaseClass;

public class LocateUsPage extends BaseClass{
	
	@FindBy(id = "locatorTextSearch")
	private WebElement locatorSearchBox;
	
	@FindBy(className = "locator__results-list")
	private WebElement searchResults;
	
	public LocateUsPage(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void typeOnLocationSearchBar(String searchText) {		
		locatorSearchBox.click();
		locatorSearchBox.sendKeys(searchText);	
		locatorSearchBox.sendKeys(Keys.ENTER);
	}
		
	public void verifyLocateUsSearch(String searchText) {
		WebDriverWait wait= new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(locatorSearchBox));
		//Scroll to see the element
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",searchResults);
		wait.until(ExpectedConditions.visibilityOf(searchResults));
		String actalResult = searchResults.getText();
		assertTrue(actalResult.contains(searchText)); 
	}
}
