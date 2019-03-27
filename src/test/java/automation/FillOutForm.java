package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillOutForm {

	public static void main(String[] args) {
		//Instantiation of chrome
		WebDriver driver = new ChromeDriver();
		
		//Navigate to a url
		driver.get("http://www.edgewordstraining.co.uk/webdriver2/");
		
		//Locating a link and clicking on it
		driver.findElement(By.partialLinkText("Access")).click();
		driver.findElement(By.partialLinkText("Forms")).click();
		
		//Locating an object by id and entering text into it
		driver.findElement(By.id("textInput")).sendKeys("some text");
		driver.findElement(By.name("textArea")).sendKeys("some more text");
		
		driver.findElement(By.partialLinkText("Submit")).click();
		
		//Close chrome
		//driver.quit();
	}
}
