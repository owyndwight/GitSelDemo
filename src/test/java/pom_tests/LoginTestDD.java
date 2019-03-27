package pom_tests;

import static helpers.HelpersStatic.waitForElementToBeClickable;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import helpers.TestBase;
import pom_pages.HomepagePOM;
import pom_pages.LoginPagePOM;

//Step 1 - Run with parametrized runner
@RunWith(Parameterized.class)
public class LoginTestDD extends TestBase {
	// Step 2 - Declare fields
	String username;
	String password;
	String age;

	// Step 3 - Declare a constructor
	public LoginTestDD(String username123, String password123, String age123) {
		username = username123;
		password = password123;
		age = age123;
	}

	// CSV Data Driven - Part 2
	@Parameters
	public static Collection<String[]> testData() throws IOException {
		return getTestData("C:\\Users\\edgewords\\Desktop\\TestData.csv");
	}

	// CSV Data Driven - Part 1
	public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));

		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
	}

	@Test
	public void test() throws InterruptedException, IOException {
		driver.get("http://www.edgewordstraining.co.uk/webdriver2/");

		HomepagePOM homepage = new HomepagePOM(driver);
		LoginPagePOM login = new LoginPagePOM(driver);

		homepage.clickLoginLink();
		login.login(username, password);

		waitForElementToBeClickable(By.linkText("Log Out"), driver);

		String actualResult = driver.findElement(By.tagName("body")).getText();
		String expectedResult = "User is Logged in";
		assertTrue(actualResult.contains(expectedResult));
	}
}
