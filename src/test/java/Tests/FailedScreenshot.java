package Tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FailedScreenshot{
	WebDriver driver;

	@BeforeMethod
	public void setup(){
	    
		driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@Test(priority = 1)
	public void loginWithValidCredential() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='oxd-brand-banner']")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void loginWithInvalidCredential() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("dmin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin124");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
//	
//	@Test(priority = 3)
//	public void loginWithValidIdWithInvalidPassword() {
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dmin121");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//	}
	
//	@Test(priority = 4)
//	public void loginWithInvalidIdWithvalidPassword() {
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admim");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='oxd-alert oxd-alert--error']")).isDisplayed());
//	}
//	
//	@Test(priority = 5)
//	public void loginWithoutCredential() {
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='Required'])[1]")).isDisplayed());
//	}

}

