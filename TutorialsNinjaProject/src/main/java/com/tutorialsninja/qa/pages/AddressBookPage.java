package com.tutorialsninja.qa.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddressBookPage {

	WebDriver driver;

//objects in that page
	@FindBy(xpath = "//a[@class='btn btn-primary' and contains(text(),\"New Address\")]")
	private WebElement NewAddresseButton;

	@FindBy(xpath = "//a[@class='btn btn-default' and contains(text(),'Back')]")
	private WebElement BackButton;

	@FindBy(xpath = "//h2 [contains(text(),'Address Book Entries')]")
	private WebElement TitleOnAddressBookPage;
//delete buttons
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr//td[@class='text-right']//a[@class='btn btn-danger']")
	private List<WebElement> DeleteButtons;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]//td[@class='text-right']//a[@class='btn btn-danger']")
	private WebElement FirstDeleteButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[2]//td[@class='text-right']//a[@class='btn btn-danger']")
	private WebElement SecondDeleteButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[3]//td[@class='text-right']//a[@class='btn btn-danger']")
	private WebElement ThirdDeleteButton;

//edit buttons	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr//td[@class='text-right']//a[@class='btn btn-info']")
	private List<WebElement> EditButtons;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]//td[@class='text-right']//a[@class='btn btn-info']")
	private WebElement FirstEditButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[2]//td[@class='text-right']//a[@class='btn btn-info']")
	private WebElement SecondEditButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[3]//td[@class='text-right']//a[@class='btn btn-info']")
	private WebElement ThirdEditButton;

	// Locate the number of entries or rows
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr")
	private List<WebElement> rows;

	public AddressBookPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//action to be performed in the page
	public String getTextTitleDisplayedOnAddressBookPage() {
		String TitleDisplayedOnAddressBookPage = TitleOnAddressBookPage.getText();
		return TitleDisplayedOnAddressBookPage;
	}

	public int getRowsCount() {
		return rows.size();

	}

	public int getDeleteButtonCount() {
		return DeleteButtons.size();

	}

	public int getEditButtonsCount() {
		return EditButtons.size();

	}

//perform the delete action		
	public void clickFirstEditButton() {
		FirstEditButton.click();

	}

//Delete button locator

	private String locateDeleteButton = "//table[@class='table table-bordered table-hover']/tbody/tr[%d]//td[@class='text-right']//a[@class='btn btn-danger']";

	public void deleteRow(int rowIndex) {
		String locator = String.format(locateDeleteButton, rowIndex);
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		deleteButton.click();
	}

//Locate Attribute Value
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[@class=\"text-left\"]")
	private WebElement AddressDetails1;
	


	
	public String getCompanyValue() {
	    // Ensure driver is initialized before accessing elements
	    if (driver != null) {
	        // Wait until AddressDetails1 is visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(AddressDetails1));

	        // Fetch the visible text from the AddressDetails1 element
	        String addressText = AddressDetails1.getText();

	        // Debug log to check the content of the text
	        System.out.println("Address text content: " + addressText);

	        // Split by newline character (as text content is usually separated by <br> in HTML)
	        String[] addressParts = addressText.split("\n");

	        // Debug log for address parts
	        System.out.println("Address Parts length: " + addressParts.length);
	        for (String part : addressParts) {
	            System.out.println("Part: " + part);  // Log each part of the address
	        }

	        // If the addressParts are sufficient, extract the company value
	        if (addressParts.length > 1) {
	            return addressParts[1]; // "company" is expected to be the second part
	        } else {
	            return "company not found";
	        }
	    } else {
	        return "Driver is not initialized";
	    }
	}

	

}
