package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy (xpath ="//input[@type='text' and @id='input-firstname']")
	private WebElement enterFirstNameField;
	
	@FindBy (xpath ="//input[@type='text' and @id='input-lastname']")
	private WebElement enterLastNameField;
	
	@FindBy (xpath ="//input[@type='email' and @id='input-email']")
	private WebElement enterEmailField;
	
	@FindBy (xpath="//input[@type='tel' and @id='input-telephone']")
	private WebElement enterTelephoneField;
	
	@FindBy (xpath="//input[@type='password' and @id='input-password']")
	private WebElement eneterPasswordField;
	
	@FindBy (xpath="//input[@type='password' and @id='input-confirm']")
	private WebElement enterConfirmPasswordField;
	
	@FindBy (xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsletterYes;
	
	@FindBy (xpath="//input[@name='newsletter' and @value='0']")
	private WebElement newsletterNo;
	
	@FindBy (xpath="//input[@type='checkbox' and @value='1'and @name='agree']")
	private WebElement checkPrivacyPolicy;
	
	
	@FindBy (xpath="//input[@type='submit' and @class='btn btn-primary']")
	private WebElement submitButton;
	
	//Warning Messages
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	@FindBy (xpath = "//div[@class='text-danger' and contains(text(), 'Password confirmation does not match password!')]")
	private WebElement confirmPasswordWarning;
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible' and contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement privacyPolicyAlert;
	
	
	public RegisterPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions
	public  void enterFirstName (String firstNameText) {
		enterFirstNameField.sendKeys(firstNameText);
		
		
	}
	
	public  void enterLastName (String lastNameText) {
		enterLastNameField.sendKeys(lastNameText);
	}
	
	public void enterTelephone (String telephoneText) {
		
		enterTelephoneField.sendKeys(telephoneText);
		
	}
	
	public void clickSubmitButton () {
		submitButton.click();
		
	}
	
	
	
	public String retrievefirstNameWarning () {
		
		String actualfirstNameWarning = firstNameWarning.getText();
		return actualfirstNameWarning;
		
		
	}
	
	public String retrieveLastNameWarning () {
		
		String actualLastNameWarning = lastNameWarning.getText();
		return actualLastNameWarning;
	}
	
	

}
