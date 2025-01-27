package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage {
	
	
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
	public  AddNewAddressPage (WebDriver driver) {

		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
//Actions
	
	public void enterFirstNameField(String FirstNameText) {
		
		FirstNameField.sendKeys(FirstNameText);
		
	}
	
	public void enterLastNameField(String LastNameText) {
		
		LastNameField.sendKeys(LastNameText);
		
	}
	
	

}
