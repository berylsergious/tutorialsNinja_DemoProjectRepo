package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	public Properties prop;
	WebDriver driver;
	
	
	public  Base() {
		
		prop = new Properties ();
		
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\configs\\config.properties");		
		try {
		FileInputStream fis = new FileInputStream (propFile);
		prop.load(fis);
		} catch (Throwable e){
			e.printStackTrace();
		}
	}
	
	
	public WebDriver initializeBrowserAndLaunchWebsite (String browserName) {


		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase ("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge") ) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));

		return driver;
	}

}
