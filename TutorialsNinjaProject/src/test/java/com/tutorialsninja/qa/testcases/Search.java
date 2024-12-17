package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base{
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp () {
		driver = initializeBrowserAndLaunchWebsite ("chrome");

	}
	
	@AfterMethod
	public void closeBrowser () {
		driver.quit();
	}
	
	
	@Test (priority=1)
	public void verifyValidSearch () {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String ActualText = driver.findElement(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")).getText();
		String ExpectedText = "Products meeting the search criteria";
		Assert.assertTrue(ActualText.contains(ExpectedText), "ExpectedText is not present");
	
		
		
	}

}
