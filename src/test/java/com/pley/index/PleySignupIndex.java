package com.pley.index;


import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.pley.Init.Common;
import com.pley.Init.SeleniumInit;
import com.pley.Verification.verifyElement;


public class PleySignupIndex extends SeleniumInit {

	Common common = new Common(driver);

	
	
	
	verifyElement verify = new verifyElement(driver);
	
	
	@Test
	public void PleySignup() throws AWTException
	{
		
		pleySignup.startMytrial();
		pleySignup.createYourAccount();
		pleySignup.shippingAddress();
		pleySignup.enterBillingNumber();
		
		
		
	}
	
	
	
	
}
