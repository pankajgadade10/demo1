package Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTestNGDemo {

	WebDriver driver;

	@BeforeTest
	public void setupTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	@Test
	public void googleSearch() {
		driver.get("https://www.google.com/");

//			locate search box and enter search string and submit
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).submit();

	}

	@AfterTest
	public void teardown() {

		driver.close();
		System.out.println("TestNG test Successfull.");
	}

}
