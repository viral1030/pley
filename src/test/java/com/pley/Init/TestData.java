package com.pley.Init;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

/**
 * Define Seller Test Data
 * 
 */

public class TestData {
	@DataProvider(name = "logdata")
	public static Object[][] Logindata() {
		Object obj[][] = { { "login1", "pass" } };

		return obj;
	}

	/*-----------------------------random data generation methods--------------------*/

	public String emailName() {

		String emailName = "KQ" + "ORG_"
				+ RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz")+"@Mailinator.com";

		return emailName;
	}


	public String shippingAddress() {

		String emailName = "Address"
				+ RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz");

		return emailName;
	}

	
	
	
	
	
}



