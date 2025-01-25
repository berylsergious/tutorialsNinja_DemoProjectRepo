package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static  ExtentReports generateExtentReport () {
		
		ExtentReports extentReport = new ExtentReports();
		
		//Instruct where to create the HTML report file
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		//Customize report HTML
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("Test Execution Status Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		
		extentReport.attachReporter(sparkReporter);
		
		
		Properties configProp = new Properties();
		
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email",configProp.getProperty("qaValidEmail"));
		extentReport.setSystemInfo("Password",configProp.getProperty("qaValidPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
		
		
		
		
		
	}
	
	
	
}
