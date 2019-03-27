package simplejunittests;

import static helpers.HelpersStatic.*;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import helpers.TestBase;

public class LoginLogoutTest extends TestBase {
	@Test
	public void LoginLogout() throws InterruptedException, IOException {
		// Navigate to a url
		driver.get("http://www.edgewordstraining.co.uk/webdriver2/");

		// Locating a link and clicking on it
		driver.findElement(By.linkText("Login To Restricted Area")).click();

		// Enter username and password
		driver.findElement(By.id("username")).sendKeys("edgewords");
		driver.findElement(By.id("password")).sendKeys("edgewords123");
		driver.findElement(By.linkText("Submit")).click();
		
		waitForElementToBeClickable(By.linkText("Log Out"), driver);

		// Try catch block
		try {
			// Assertion to check we are logged in
			String actualResultLoggedIn = driver.findElement(By.cssSelector("body")).getText();
			String expectedResultLoggedIn = "User is Logged inFAILTHIS";
			assertTrue("User could not log in successfully", actualResultLoggedIn.contains(expectedResultLoggedIn));
		} catch (AssertionError error) {
			verificationErrors.append(error);
			takeScreenshot("loggedin", driver);
		}

		// Click log out
		driver.findElement(By.linkText("Log Out")).click();

		handleAlert(driver);

		waitForElementToBeClickable(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"), driver);
		
		takeScreenshot("loggedout", driver);
		takeScreenshot("addrecord", driver);

		// Assertion to check we are logged out
		String actualResultLoggedOut = driver.findElement(By.cssSelector("body")).getText();
		String expectedResultLoggedOut = "User is not Logged in";
		assertTrue("User was not logged out successfully", actualResultLoggedOut.contains(expectedResultLoggedOut));
	}
}
