package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgzDemo {
	WebDriver driver;
	
	@BeforeMethod
	public void launch() throws Exception {
//		driver = new ChromeDriver();
//		driver.get("https://google.com");
	}
	
//	@Test (groups = {"smoke", "regression"})
//	public void search() {
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("Selenium");
//		search.submit();
//		System.out.println("Method 1");
//	}
//	
//	@Test ()
//	public void search1() {
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("Selenium");
//		search.submit();
//		System.out.println("Method 1");
//	}
//	@Test (groups = "regression")
//	public void search2() {
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("Selenium");
//		search.submit();
//		System.out.println("Method 1");
//	}
//	
//	@Test (groups = "smoke")
//	public void search3() {
//		System.out.println("Method 2");
//	}
//	
//	@Test (dependsOnGroups = "smoke")
//	public void search4() {
//		System.out.println("Method 2");
//	}
	
	
	
	@Test (dataProvider = "getAccountNames")
	public void login(String username) throws Exception {
		System.out.println("Username: "+username);
	}
	
	
	@DataProvider
	public Object[][] readUserData() {
		
//		Read excel --> return object
		
		return new Object[][] {{"mithun.@tekarch.com", "Mithun123"}, 
			{"reshma@gmail.com", "reshma123"}, {"deekshith@tekarch.com", "deekshith123"}};
		
	}
	
	
	@DataProvider
	public Object[] getAccountNames() {
		
//		Read excel --> return object
		
		Object arr[] = {};
		
		return  arr;
		
	}
	
//	@Test (invocationCount = 10, timeOut = 60000)
//	public void aahome() throws InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("home 2");
//	}
	
	
	
	@AfterMethod
	public  void closeBrowser() {
//		driver.close();
	}

}
