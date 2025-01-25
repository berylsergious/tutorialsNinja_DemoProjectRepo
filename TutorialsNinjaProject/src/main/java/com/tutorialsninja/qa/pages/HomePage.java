package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
//Objects
	@FindBy (xpath ="//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']")
	private WebElement MyAccountDropdownMenu;
	
	@FindBy (linkText="Login")
	private WebElement LoginOption;
	
	@FindBy (linkText="Register")
	private WebElement RegisterOption;
	
	 
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
//Actions
	
	public void ClickOnMyAccountDropdownMenu () {
		
		MyAccountDropdownMenu.click();
	}
	
	public void ClickOnLoginOption() {
		
		LoginOption.click();
	}
	
	public void ClickOnRegisterOptio () {
		
		RegisterOption.click();
		
	}
	

	
}
