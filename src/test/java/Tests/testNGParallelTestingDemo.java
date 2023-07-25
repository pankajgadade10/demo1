package Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGParallelTestingDemo {
	
	WebDriver driver;
	
	@Test
	public void test1() throws Exception {
		System.out.println("I am inside test1| "+ Thread.currentThread().getId());
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed());
		driver.close();
	}
	
	@Test
	public void test2() throws Exception {
		System.out.println("I am inside test2| "+ Thread.currentThread().getId());
		
		driver = WebDriverManager.firefoxdriver().create();
		driver.get("https://selenium.dev");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='navbar-logo']")).isDisplayed());
		driver.close();
	}

}
