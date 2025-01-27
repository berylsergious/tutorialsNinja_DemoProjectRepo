package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AddressBookPage;
import com.tutorialsninja.qa.pages.EditAddressPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.MyAccountPage;


public class ManageAddressBook extends Base {

	public ManageAddressBook () {
		
		super();
	}
	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AddressBookPage addressBookPage;
	MyAccountPage myAccountPage;
	EditAddressPage editAddressPage;
	
	@BeforeMethod
	public void setup () {
		
		driver = initializeBrowserAndLaunchWebsite (prop.getProperty("browserName"));


		homePage= new HomePage(driver);
		homePage.ClickOnMyAccountDropdownMenu();
		homePage.ClickOnLoginOption();
		
		
		loginPage = new LoginPage (driver);
		loginPage.LoginWithCredentials(prop.getProperty("qaValidEmail"),prop.getProperty("qaValidPassword"));
		
		
		myAccountPage = new MyAccountPage (driver);
		myAccountPage.clickModifyAddressHyperlink();
		
	
	}
	


	@AfterMethod
	public void teardown () {
		driver.quit();
		
	}
	
	
	
	@Test (priority= 1)
	public void verifyAndCountAddressBookEntries () {
		

		addressBookPage = new AddressBookPage (driver);
		Assert.assertTrue(addressBookPage.getTextTitleDisplayedOnAddressBookPage().contains("Address Book Entries"),"Address Book Entries is not present");
		
		
	}
	
	@Test (priority=2)
	public void verifyEditAddress () {
	//Get all Original Values
		
		addressBookPage = new AddressBookPage (driver);
		
		String originalCompany = addressBookPage.getCompanyValue();
		

		
		addressBookPage.clickFirstEditButton();
		
		editAddressPage =new EditAddressPage (driver);
		String editCompany = editAddressPage.getCompanyFieldValue();

		
	    Assert.assertEquals(originalCompany, editCompany, "Company value mismatch!");
	   
		
		
		
		
		
		
		
	}
	

	
	@Test (priority=3)
	public void verifyDeleteAddress () {
		addressBookPage = new AddressBookPage (driver);
		int rowsCountInitially = addressBookPage.getRowsCount();
		
//Your address has been deleted		
		addressBookPage.deleteRow(1);
		WebDriverWait wait =new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"), rowsCountInitially -1 ));

//verify the address has been deleted
		
		
		 Assert.assertEquals(addressBookPage.getRowsCount(), rowsCountInitially - 1, "Row was not deleted.");

		
	}
	
	
	
	
	
	
}
