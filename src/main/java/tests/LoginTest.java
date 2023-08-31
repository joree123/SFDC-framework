package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import utils.FileUtils;


public class LoginTest extends BaseTest {
	
	
		
		@Test
		public void loginTest1() throws InvalidFormatException, IOException, InterruptedException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get("https://login.salesforce.com");
//			String[] creds = ExcelUtils.readLoginTestData(1);
			lp.username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			lp.password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
			
//			Assert.assertEquals(lp.selectRememberMeCheckBox(), "");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='Mithunqwe';", lp.password);
			
			Thread.sleep(8000);
//			lp.loginButton.click();
			
			
		}
		
		
//		@Test
		public void loginTest2() {
			
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get("https://login.salesforce.com");
			lp.username.sendKeys("mithun");
			lp.password.clear();
			lp.loginButton.click();
			
		}
		
		

}
