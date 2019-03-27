package pom_tests;

import static helpers.HelpersStatic.waitForElementToBeClickable;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;

import helpers.TestBase;
import pom_pages.HomepagePOM;
import pom_pages.LoginPagePOM;

public class LoginTest extends TestBase {

	@Test
	public void test() throws InterruptedException, IOException {
		driver.get("http://www.edgewordstraining.co.uk/webdriver2/");

		HomepagePOM homepage = new HomepagePOM(driver);
		LoginPagePOM login = new LoginPagePOM(driver);

		homepage.clickLoginLink();
		login.login("edgewords", "edgewords123");

		waitForElementToBeClickable(By.linkText("Log Out"), driver);

		String actualResult = driver.findElement(By.tagName("body")).getText();
		String expectedResult = "User is Logged in";
		assertTrue(actualResult.contains(expectedResult));
		//comment for sc
	}
}
