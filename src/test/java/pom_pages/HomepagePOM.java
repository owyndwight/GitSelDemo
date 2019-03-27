package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM {
	//Step 1 - Declare webdriver field
	WebDriver driver;
	
	//Step 2 - Declare constructor
	public HomepagePOM(WebDriver driver123) {
		driver = driver123;
		PageFactory.initElements(driver, this);
	}
	
	//Step 3 - Declare locators
	@FindBy (linkText = "Login To Restricted Area") WebElement loginLink;
	
	//Step 4 - Declare methods
	public void clickLoginLink() {
		loginLink.click();
	}
}
