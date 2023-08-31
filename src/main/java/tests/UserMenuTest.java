package tests;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;

@Listeners(SFDCListeners.class)
public class UserMenuTest extends BaseTest {
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	@Test (priority = 4)
	public void userMenuDropDown_TC06(Method name) throws IOException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		BaseTest.test.info("Username element is visible");
		ump.userMenu.click();
		BaseTest.test.info("clicked on usermenu");
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
		BaseTest.test.info("Verified User Menu items");
		Assert.assertTrue(ump.selectMyProfile(), "");
		BaseTest.test.info("Selected my profile");
		CommonUtils.waitForElement(driver, ump.profilePage);
		BaseTest.test.info("profile page loaded");
		Assert.assertTrue(ump.isProfilePageVisible(), "");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		BaseTest.test.info("Edit contact pop up verified");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "Tekarch"), "");
		BaseTest.test.info("Verified last name change");
		Assert.assertTrue(ump.verifyCreatePost(driver, "Hello welcome to java"));
		BaseTest.test.info("Verified create post");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.LOGIN_TESTDATA_FILE_PATH));
		BaseTest.test.info("Verified file upload");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH));
		BaseTest.test.info("Verified photo upload");
		
		
	}
	
	@Test (priority = 0)
	public void userMenuDropDown_TC07() {
		
		System.out.println("userMenuDropDown_TC07");
	}
	
	@Test (priority = -1)
	public void userMenuDropDown_TC08() {
		
		System.out.println("userMenuDropDown_TC08");
	}
	
	@Test ()
	public void userMenuDropDown_TC09() {
		
		System.out.println("userMenuDropDown_TC09");
		throw new ArithmeticException("fsjhfb");
	}

}
