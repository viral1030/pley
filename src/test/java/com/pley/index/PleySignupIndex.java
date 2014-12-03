package com.pley.index;

import org.testng.annotations.Test;

import com.pley.Init.Common;
import com.pley.Init.SeleniumInit;
import com.pley.Verification.verifyElement;

public class PleySignupIndex extends SeleniumInit {

	Common common = new Common(driver);

	verifyElement verify = new verifyElement(driver);

	@Test
	public void PleySignup() {

		pleySignup.startMytrial();
		pleySignup.createYourAccount();
		pleySignup.shippingAddress();
		pleySignup.enterBillingNumber();
		pleySignup.verifyPleyRegistration();
		pleySignup.editPleyList();
		
		
		common.EmbedSaucelabVideo(driver);

	}

}
