package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAddressPage {

	
	WebDriver driver;
	

	//elements in the page
		@FindBy (xpath = "//input[@id='input-firstname']")
		private WebElement FirstNameField;
		
		
		@FindBy (xpath = "//input[@id='input-lastname']")
		private WebElement LastNameField;
		
		
		@FindBy (xpath = "//input[@id='input-company']")
		private WebElement CompanyField;
		
		
		@FindBy (xpath = "//input[@id='input-address-1']")
		private WebElement Address1Field;
		
		
		@FindBy (xpath = "//input[@id='input-address-2']")
		private WebElement Address2Field;
		
		
		@FindBy (xpath = "//input[@id='input-city']")
		private WebElement CityField;
		
		
		@FindBy (xpath = "//input[@id='input-postcode']")
		private WebElement PostCodeField;
		
		
		@FindBy (xpath = "//input[@type='radio' and @value='1']")
		private WebElement DefaultAddressYes;
		
		
		@FindBy (xpath = "//input[@type='radio' and @value='0']")
		private WebElement DefaultAddressNo;
		
		
	//initiate the driver
		public  EditAddressPage (WebDriver driver) {

			this.driver =driver;
			PageFactory.initElements(driver, this);
			
		}
	
	
	
	public String getCompanyFieldValue () {
		String CompanyFieldValue = CompanyField.getText();
		return CompanyFieldValue;
	}
	
	public String getAddress1FieldValue () {
		String CompanyFieldValue = Address1Field.getText();
		return CompanyFieldValue;
	}
	
	public String getAddress2FieldValue () {
		String CompanyFieldValue = Address2Field.getText();
		return CompanyFieldValue;
	}
	
	
	
	
	
	
	
	
	
}
