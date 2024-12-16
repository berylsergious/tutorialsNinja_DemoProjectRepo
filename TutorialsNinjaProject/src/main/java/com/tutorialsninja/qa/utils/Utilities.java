package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {
	public static String generateEmailTimeStamp () {

		Date date =new Date();
		
		String TimeStampText = date.toString().replace(" ","_").replace(":","_");
		return "tutorialsninja"+TimeStampText+"@yopmail.com";
		
	}
}
