package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Dummy {
	
	@Test ()
	public void search2() {
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("Selenium");
//		search.submit();
//		System.out.println("Method 1");
	}
	
	@Test ()
	public void search3() {
		System.out.println("Method 1");
	}
	
	@Test ()
	public void search4() {
		System.out.println("Method 1");
	}
	
//	@AfterMethod
//	public  void closeBrowser() {
//		driver.close();
//	}
	WebDriver driver;
	
	
	@Test ()
	public void login2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
		search.submit();
		System.out.println("Method 1");
	}
	
	@Test ()
	public void login3() {
		System.out.println("Method 2");
	}

}
