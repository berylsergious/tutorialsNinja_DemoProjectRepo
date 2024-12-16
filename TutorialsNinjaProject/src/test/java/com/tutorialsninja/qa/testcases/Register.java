package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp () {
		driver = initializeBrowserAndLaunchWebsite ("edge");	    
	    // Click 'My Account' -> 'Register'
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Register")).click();
	}
	@AfterMethod
	public void closeBrowser () {
		driver.quit();
	}
	@Test(priority =1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
	    
	    // Fill in mandatory fields: First Name, Last Name, Email
	    driver.findElement(By.id("input-firstname")).sendKeys("tutorialsninja");
	    driver.findElement(By.id("input-lastname")).sendKeys(Utilities.generateEmailTimeStamp ());
	    driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp ());
	    driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
	    driver.findElement(By.id("input-password")).sendKeys("12345");
	    driver.findElement(By.id("input-confirm")).sendKeys("12345");
	    driver.findElement(By.name("agree")).click();
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	    
	    
	}
	



}
