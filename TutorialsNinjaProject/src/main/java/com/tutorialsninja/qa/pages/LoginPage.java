package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//WebElements
	@FindBy (id ="input-email")
	private WebElement EnterEmailField;
	
	@FindBy (id="input-password")
	private WebElement EnterPasswordField; 
	
	@FindBy (xpath ="//input[@class='btn btn-primary' and @value='Login']")
	private WebElement LoginButton;
	
	@FindBy (xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement  LoginWarningMessageText;
	
	
	public LoginPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	

	//actions
	public void LoginWithCredentials(String EmailText, String Passphrase) {
	EnterEmailField.sendKeys(EmailText);
	EnterPasswordField.sendKeys(Passphrase);
	LoginButton.click();
	}
	
	public void EnterEmailAddress (String EmailText) {
		
		EnterEmailField.sendKeys(EmailText);
	}
	
	public void EnterPassword (String Passphrase) {
		EnterPasswordField.sendKeys(Passphrase);
		
	}
	public void ClickLoginButton () {
		LoginButton.click();
		
	}
	
	public String retrieveWarningMessageText () {
		
		String hasLoginWarningMessageText = LoginWarningMessageText.getText();
		return hasLoginWarningMessageText;
		
	}
	
	
}
