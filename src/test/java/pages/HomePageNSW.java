package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class HomePageNSW extends BaseClass {
	
	@FindBy(id = "edit-submit-site-search")
	private WebElement searchButton;
	
	@FindBy(className = "locate-us-button")
	private WebElement locateUsButton;
	
	@FindBy(id = "edit-contains")
	private WebElement searchBar;
	
	public HomePageNSW(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void clickOnSearchButton() {
			searchButton.click();
	}
	
	public void clickOnLocateUsButton() {
			locateUsButton.click();
	}
	
	public void typeOnSearchBar(String searchText) {		
			searchBar.click();
			searchBar.sendKeys(searchText);	
	}

}
