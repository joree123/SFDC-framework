package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		System.setProperty("webdriver.chrome", "/Users/user/Downloads/chromedriver_mac_arm64/chromedriver");
//		WebDriverManager.chromedriver().setup();
		
		driver.get("https://login.salesforce.com/");
		
		WebElement email = driver.findElement(By.id("username"));
		
		email.sendKeys("jul22.qa@ta.com");
		
		driver.findElement(By.id("password")).sendKeys("Mithun123");
		
		driver.findElement(By.id("Login")).click();
		
//		Thread.sleep(5000); // hard wait
		
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
		
		WebElement errorText;
		if(driver.findElement(By.id("error")).isDisplayed()) {
		
			errorText = driver.findElement(By.id("error"));
			
			String actual = errorText.getText();
		}
		
		
		
		
		
		
//		if(actual.equals(expected)) {
//			System.out.println("PASSED");
//		} else {
//			System.out.println("FAILED");
//		}
//		
		
		
		
//		Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
//		
//		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id("error"));
//			}
//		});
		
		
	}
	
	

}
