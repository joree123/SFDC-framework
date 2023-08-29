package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
//	Requirements
//	Cross browser support
//	Parallel support -
//	Proper reporting - Accurate Assertion, Screenshots
//	Support of Logs in the framework
	
	@BeforeTest
	public static void setDriver() {
		WebDriver driver = BaseTest.getBrowserType("chrome", true);
		threadLocalDriver.set(driver);
	}
	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	
	@AfterTest
	public static void removeDriver() {
		getDriver().close();
		threadLocalDriver.remove();
	}
	
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		WebDriver driver;
		String browserType = browserName.toLowerCase();
		switch (browserType) {
		case "chrome":
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;	
			
		case "egde":
			driver = new EdgeDriver();
			break;
					
		default:
			driver = null;
			break;
		}
		
		return driver;
	}

}
