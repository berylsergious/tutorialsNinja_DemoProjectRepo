package com.tutorialsninja.qa.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.MyAccountPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base {
	
	public Login() {
		super();
	}
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	
	
	@BeforeMethod
	public void setUp () {
		
		driver = initializeBrowserAndLaunchWebsite (prop.getProperty("browserName"));
		
		homePage= new HomePage(driver);
		loginPage = new LoginPage (driver);
		myAccountPage = new MyAccountPage (driver);
		homePage.ClickOnMyAccountDropdownMenu();
		homePage.ClickOnLoginOption();

		
	}
	
	@AfterMethod
	public void quitBrowser () {
		driver.quit();
	}

	

	@Test (priority=1)
	public void verifyLoginWithValidCredentiols() {
		
		
		loginPage.EnterEmailAddress(prop.getProperty("qaValidEmail"));
		loginPage.EnterPassword(prop.getProperty("qaValidPassword"));
		loginPage.ClickLoginButton();

		Assert.assertTrue(myAccountPage.getTextDisplayedOfEditYourAccountInformation().contains("Edit your account information"),"Edit your account information is not present");
		

	}
	@Test(priority=2)
	public void verifyLoginWithInvalidEmail() {
		loginPage.EnterEmailAddress(Utilities.generateEmailTimeStamp ());
		loginPage.EnterPassword(prop.getProperty("qaValidPassword"));
		loginPage.ClickLoginButton();
		
		
		
		
		
		Assert.assertTrue(loginPage.retrieveWarningMessageText().contains(dataProp.getProperty("invalidPasswordWarning")),"text displayed is not as expected");

	}

	@Test(priority=3)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.EnterEmailAddress(prop.getProperty("qaValidEmail"));
		loginPage.EnterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.ClickLoginButton();
		

		String warningMessageFetched = loginPage.retrieveWarningMessageText();
		
		// Assert that the actual message matches one of the expected warnings
		Assert.assertTrue(warningMessageFetched.equals(dataProp.getProperty("invalidPasswordWarning")) || warningMessageFetched.equals(dataProp.getProperty("attemptExceededForEmailWarning")),"Warning message not matching any expected value. Actual: " + warningMessageFetched);

	}
	
	
	
	
	
}
