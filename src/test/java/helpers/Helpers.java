package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
	// Step 1 - Declare webdriver field
	WebDriver driver;

	// Step 2 - Declare a constructor
	public Helpers(WebDriver driver123) {
		driver = driver123;
	}

	// Step 3 - Declare methods
	public void handleAlert() {
		// Handle alert
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	public void waitForElementToBeClickable(By locator) {
		// Explicit conditional delay
		WebDriverWait waitForLogOutLinkToAppear = new WebDriverWait(driver, 30);
		waitForLogOutLinkToAppear.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
}