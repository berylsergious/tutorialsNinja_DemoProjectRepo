package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;


public class Register extends Base {
	
	public Register () {
		super ();
	}
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	
	
	@BeforeMethod
	public void setUp () {
		driver = initializeBrowserAndLaunchWebsite (prop.getProperty("browserName"));	    
	   
		homePage = new HomePage(driver);
		registerPage =new RegisterPage (driver);
		homePage.ClickOnMyAccountDropdownMenu();
		homePage.ClickOnRegisterOptio();
	}
	@AfterMethod
	public void closeBrowser () {
		driver.quit();
	}
	@Test(priority =1)
	public void verifyClickingWithIncompleteForm() {
		registerPage.enterTelephone(prop.getProperty("ValidTelephone"));
		registerPage.clickSubmitButton();
		
	
		Assert.assertEquals(registerPage.retrievefirstNameWarning(),dataProp.getProperty("FirstNameWarning"), "is not displayed");
		Assert.assertEquals(registerPage.retrieveLastNameWarning(), dataProp.getProperty("LastNameWarning"),"is not displayed");
	    
	    
	    
	}
	
	




}
