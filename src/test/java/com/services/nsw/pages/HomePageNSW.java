package com.services.nsw.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class HomePageNSW extends BaseClass {
	
	@FindBy(linkText = "Find locations")
	private WebElement locateUS;
	
	@FindBy(className = "form__text")
	private WebElement searchBar;
	
	public HomePageNSW(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void clickOnLocateUs() {
			locateUS.click();
	}
	
	public void typeOnSearchBar(String searchText) {		
			searchBar.click();
			searchBar.sendKeys(searchText);	
			searchBar.sendKeys(Keys.ENTER);
	}
}
