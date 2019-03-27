package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
	//Step 1 - Declare webdriver field
	WebDriver driver;
	
	//Step 2 - Declare constructor
	public LoginPagePOM(WebDriver driver123) {
		driver = driver123;
		PageFactory.initElements(driver, this);
	}
	
	//Step 3 - Declare locators
	@FindBy (id = "username") WebElement usernameField;
	@FindBy (id = "password") WebElement passwordField;
	@FindBy (linkText = "Submit") WebElement submitBtn;
	
	//Step 4 - Declare methods
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickSubmitButton() {
		submitBtn.click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmitButton();
	}
}
