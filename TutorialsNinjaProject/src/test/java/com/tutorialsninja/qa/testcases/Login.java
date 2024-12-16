package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base {
	WebDriver driver;

	@BeforeMethod
	public void setUp () {
		
		driver = initializeBrowserAndLaunchWebsite ("chrome");
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click(); 
		driver.findElement(By.linkText ("Login")).click();
		
		
	}
	
	@AfterMethod
	public void quitBrowser () {
		driver.quit();
	}

	

	@Test (priority=1)
	public void verifyLoginWithValidCredentiols() {

		driver.findElement(By.id("input-email")).sendKeys ("tutorialsninja.demoqa@yopmail.com");
		driver.findElement(By.id("input-password")).sendKeys("demoqa0465194431");
		driver.findElement(By.xpath("//input [@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}
	@Test(priority=2)
	public void verifyLoginWithInvalidEmail() {

		driver.findElement(By.id("input-email")).sendKeys (Utilities.generateEmailTimeStamp ());
		driver.findElement(By.id("input-password")).sendKeys("demoqa0465194431");
		driver.findElement(By.xpath("//input [@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"text displayed is not as expected");

	}

	@Test(priority=3)
	public void verifyLoginWithInvalidCredentials() {

		driver.findElement(By.id("input-email")).sendKeys ("tutorialsninja.demoqa@yopmail.com");
		driver.findElement(By.id("input-password")).sendKeys("demoperf0465194431");
		driver.findElement(By.xpath("//input [@value='Login']")).click();

		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertEquals(actualWarningMessage,"Warning: No match for E-Mail Address and/or Password.","text displayed is not as expected");

	}
}
