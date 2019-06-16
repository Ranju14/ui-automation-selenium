package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class LocateUsPage extends BaseClass{
	
	@FindBy(id = "locatorTextSearch")
	private WebElement searchBox;
	
	@FindBy(className = "form__actions")
	private WebElement searchIcon;
	
	@FindBy(className = "locator__results-list")
	private WebElement searchResults;
	
	public LocateUsPage(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void typeOnLocationSearchBar(String searchText) {		
		searchBox.click();
		searchBox.sendKeys(searchText);	
	}
	
	public void clickOnLocationSearchIcon() {
		searchIcon.click();
	}
	
	public void verifyLocateUsSearch(String searchText) {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",searchResults);
//		 wait.until(ExpectedConditions.presenceOfElementLocated(searchResultHeading));
		 String actalResult = searchResults.getText();
		 assertTrue(actalResult.contains(searchText));
		   
	}

}
