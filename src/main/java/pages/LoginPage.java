package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;

	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;

	public boolean selectRememberMeCheckBox() {
		logger.info("LoginPage : selectRememberMeCheckBox : Started");
		boolean isSelected = false;
		if (!rememberMe.isSelected()) {
			logger.info("LoginPage : selectRememberMeCheckBox : remember me checkbox selected");
			rememberMe.click();
			isSelected = true;
		}
		logger.info("LoginPage : selectRememberMeCheckBox : Ended");
		return isSelected;
	}

	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		logger.info("LoginPage : loginToApp : started");
		driver.manage().window().maximize();
		logger.info("LoginPage : loginToApp : Window maximized");
		if (CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
			loginButton.click();
			logger.info("LoginPage : loginToApp : clicked ion login button");
		}
	}
}
