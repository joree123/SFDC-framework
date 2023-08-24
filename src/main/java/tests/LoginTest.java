package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest extends BaseTest {
	
	
		
		@Test
		public void loginTest1() {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get("https://login.salesforce.com");
			lp.username.sendKeys("mithun");
			lp.password.sendKeys("Mithunfdv");
			lp.loginButton.click();
			
			
		}
		
		
		@Test
		public void loginTest2() {
			
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get("https://login.salesforce.com");
			lp.username.sendKeys("mithun");
			lp.password.clear();
			lp.loginButton.click();
			
		}
		
		

}
