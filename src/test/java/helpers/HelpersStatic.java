package helpers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpersStatic {
	public static void handleAlert(WebDriver driver) {
		// Handle alert
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	public static void waitForElementToBeClickable(By locator, WebDriver driver) {
		// Explicit conditional delay
		WebDriverWait waitForLogOutLinkToAppear = new WebDriverWait(driver, 30);
		waitForLogOutLinkToAppear.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void takeScreenshot(String fileName, WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File("C:\\Users\\edgewords\\Desktop\\Screenshots\\"+fileName+".png"));
	}
}
