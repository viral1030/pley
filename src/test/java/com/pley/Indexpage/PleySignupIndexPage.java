package com.pley.Indexpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pley.Init.Common;
import com.pley.Init.TestData;
import com.pley.Verification.AbstractPage;
import com.pley.Verification.datagen;
import com.pley.Verification.verifyElement;

public class PleySignupIndexPage extends AbstractPage {

	public PleySignupIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Common common = new Common(driver);
	TestData data = new TestData();
	verifyElement verify = new verifyElement(driver);
	datagen randomgen = new datagen();
	public static int testStepNo = 0;

	@FindBy(xpath = ".//*[@id='cc-num']")
	private WebElement cardNumber;

	@FindBy(xpath = ".//*[@id='cc-exp']")
	private WebElement expires;

	@FindBy(xpath = ".//*[@id='cc-cvc']")
	private WebElement cvc;

	@FindBy(xpath = ".//*[@id='billing']//input[@value='Make Payment']")
	private WebElement makePaymentButton;

	@FindBy(xpath = ".//*[@data-app-name='signup'][contains(.,'Start')]")
	private WebElement startMyFreeTrial;

	@FindBy(xpath = "//*[@id='fullname']")
	private WebElement fullName;

	@FindBy(xpath = "//*[@id='email']")
	private WebElement email;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//*[@id='signup1']/div[4]/div/button")
	private WebElement continueButtonCreateAccount;

	@FindBy(xpath = "//*[@id='formaddress']/input")
	private WebElement address1;

	@FindBy(xpath = "//*[@id='address2']")
	private WebElement address2;

	@FindBy(xpath = "//*[@id='city']")
	private WebElement city;

	@FindBy(xpath = "//*[@id='state']")
	private WebElement state;

	@FindBy(xpath = "//*[@id='country']")
	private WebElement Country;

	@FindBy(xpath = "//*[@id='zip_code']")
	private WebElement Zip;

	@FindBy(xpath = "//*[@id='signup2']/div[7]/div/button")
	private WebElement continueButtonShippingInfo;

	public void startMytrial() {

		common.waitForElement(startMyFreeTrial);
		common.pause(2);
		startMyFreeTrial.click();

	}

	public void createYourAccount() {

		common.waitForElement(fullName);

		common.pause(3);

		fullName.sendKeys("Jethalal Ghada");
		common.pause(1);
		email.sendKeys(data.emailName());
		common.pause(1);
		password.sendKeys("qwerty");
		common.pause(1);
		continueButtonCreateAccount.click();

	}

	public void shippingAddress() {

		common.waitForElement(address1);
		common.pause(2);
		address1.sendKeys(data.shippingAddress());
		common.pause(1);
		address2.sendKeys(data.shippingAddress());
		common.pause(1);

	    city.sendKeys("Ahmedabad");
	    
	    common.pause(1);
        state.sendKeys("Gujarat");

	    common.pause(1);
        common.selectFromComboByVisibleText(Country, "India");
	    
	    
	    common.pause(1);
      Zip.sendKeys("12345");
	    common.pause(1);

	    continueButtonShippingInfo.click();
	
	}

	public void enterBillingNumber() {
		
		common.waitForElement(cardNumber);
		common.pause(2);
		cardNumber.sendKeys("4111 1111 1111 1111");
		common.pause(2);
		expires.sendKeys("1219");
		common.pause(2);
		cvc.sendKeys("1234");
		common.pause(2);
		makePaymentButton.click();
		common.pause(2);

	}
}
