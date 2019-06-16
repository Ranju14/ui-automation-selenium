package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(className = "pane-content")
	private WebElement searchResultHeading;
	
	@FindBy(className = "block__search-results-intro")
	private WebElement actualSearchStringResult;
	
	
	public SearchResultPage(WebDriver driver){
	       BaseClass.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	
	public void verifySearchResultPage(String searchText) {
		 WebDriverWait wait= new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pane-content")));
//		 wait.until(ExpectedConditions.presenceOfElementLocated(searchResultHeading));
		 String actalResult = actualSearchStringResult.getText();
		 assertTrue(actalResult.contains(searchText));
		   
	}

}
