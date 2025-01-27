package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	
	
	//objects
	@FindBy (linkText="Edit your account information")
	WebElement EditAccountHyperlink;
	
	@FindBy (linkText="Modify your address book entries")
	WebElement AddressBookHyperlink;
	
	
	
	public  MyAccountPage (WebDriver driver) {
		 this.driver =driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	
	
	//actions
	public void clickModifyAddressHyperlink() {
		AddressBookHyperlink.click();
	}
	
	public String getTextDisplayedOfEditYourAccountInformation () {
		String DisplayStatus = EditAccountHyperlink.getText();
		return DisplayStatus;
	}
	
}
