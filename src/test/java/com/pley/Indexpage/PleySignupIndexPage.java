package com.pley.Indexpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pley.Init.Common;
import com.pley.Init.TestData;
import com.pley.Verification.AbstractPage;
import com.pley.Verification.verifyElement;

public class PleySignupIndexPage extends AbstractPage {

	public PleySignupIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Common common = new Common(driver);
	static TestData data = new TestData();
	verifyElement verify = new verifyElement(driver);

	public static int testStepNo = 0;

	@FindBy(xpath = ".//*[@id='cc-num']")
	private WebElement cardNumber;

	@FindBy(xpath = ".//*[@id='cc-exp']")
	private WebElement expires;

	@FindBy(xpath = ".//*[@id='cc-cvc']")
	private WebElement cvc;

	@FindBy(xpath = ".//*[@id='form-submit']")
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

		common.logstep("</br>Step 1. open url : https://dev2.pley.com/ </br>");
	    common.waitForElement(startMyFreeTrial);
	    verify.verificationMethod(startMyFreeTrial, "url opened successfully");
		
	    common.logstep("</br>Step 2. Click on 'Start My Free Trial' Button </br>");
		common.pause(2);
		startMyFreeTrial.click();

	}
	
	static String emailadd = data.emailName();
	
	public void createYourAccount() {

		common.logstep("</br>Step 3. Fill 'Create Your Account Detail' and click on 'Continue' button </br>");
		common.waitForElement(fullName);
		common.pause(3);

		common.logstep("Data Entered As below :");
		common.logverification("Jethalal Ghada");
		fullName.sendKeys("Jethalal Ghada");
		common.pause(1);
		common.logverification("Full Name : Jethalal Ghada");
		
		common.logverification("Email address :"+emailadd);
		email.sendKeys(emailadd);
		common.pause(1);
		
		common.logverification("Password : qwerty");
		password.sendKeys("qwerty");
		common.pause(1);
		
		common.logstep("Click on continue button");
		continueButtonCreateAccount.click();

	}

	static String addressOne = data.shippingAddress();
	static String addressTwo = data.shippingAddress();
	
	public void shippingAddress() {

		common.logstep("</br>Step 4. Fill 'Enter Shipping Information' and click on 'Continue' button </br>");
		common.logstep("Entered data as below :");
			
		common.logverification("Address1 : "+addressOne);
		common.waitForElement(address1);
		common.pause(2);
		
		address1.sendKeys(addressOne);
		common.pause(1);
		
		common.logverification("Address2 : "+addressTwo);
		address2.sendKeys(addressTwo);
		common.pause(1);

		common.logverification("City : Ahmedabad");
	    city.sendKeys("Ahmedabad");
	    
	    common.logverification("State : Gujarat");
	    common.pause(1);
        state.sendKeys("Gujarat");

        common.logverification("Country : India");
	    common.pause(1);
        common.selectFromComboByVisibleText(Country, "India");
	    
        common.logverification("Zip : 12345");
	    common.pause(1);
        Zip.sendKeys("12345");
	    common.pause(1);

	    common.logstep("Click on 'Countinue' Button");
	    continueButtonShippingInfo.click();
	
	}

	
	public void enterBillingNumber() {
		common.logstep("</br> Step 5. Fill 'Enter Billing Information' and click on 'Make Payment' button </br>");
		common.logstep("Entered data as below :");
		common.logverification("Card Number : 4111 1111 1111 1111");
		common.waitForElement(cardNumber);
		common.pause(2);
		cardNumber.sendKeys("4111");
		cardNumber.sendKeys("1111");
		cardNumber.sendKeys("1111");
		cardNumber.sendKeys("1111");
		
		common.pause(2);
		common.logverification("Expires : 12/2019");
		expires.sendKeys("12");
		expires.sendKeys("2019");
		common.pause(2);
		
		common.logverification("CVV : 123");
		cvc.sendKeys("123");
		common.pause(2);
		common.logstep("Click on 'Make Payment' Button");
		makePaymentButton.click();
		common.pause(2);

		}
	
	@FindBy(xpath=".//*[@id='welcome']/h1")
	WebElement welcomeMsg;
	
	public void verifyPleyRegistration()
	{
		common.waitForElement(welcomeMsg);
		common.pause(2);
		
		verify.verificationMethod(welcomeMsg, "User should see Welcome Message like : "+welcomeMsg.getText());
		
	}
	

	@FindBy(xpath=" .//a[contains(.,'Next')]")
	WebElement NextButton;
	
	@FindBy(xpath="//a[contains(.,'Create')]")
	WebElement CreateYourPleyList;
	
	@FindBy(xpath=".//*[@id='step3']/div/div[1]/p")
	WebElement verificationMessage;
	
		
	public void editPleyList()
	{
		common.logstep("</br> Step 6. add Pley List");
		common.logstep("</br> a. Select How many Pleyers? , Gender and Age </br>");
		common.logstep("data selected As below :");
		common.logverification("How many Pleyers? : 1 Pleyers");
		common.logverification("gender : Boy");
		common.logverification("Age : 3-5Yrs");
		common.logverification("Click on 'Next' Button");
		common.waitForElement(NextButton);
		common.pause(2);
		
		NextButton.click();
		
		common.pause(5);
		
		common.logstep("</br> b. Select Themes and Click on 'Create Your Pley List' Button</br>");
		
		common.waitForElement(CreateYourPleyList);
		WebElement selectToys = driver.findElement(By.xpath(".//*[@id='step2']/div/ul/li["+data.toysSelect()+"]/div/span/input"));
		selectToys.click();
		
		common.pause(1);
		CreateYourPleyList.click();
		
		
		common.waitForElement(verificationMessage);
		common.pause(2);
		
		verify.verificationMethod(verificationMessage,"User see message like : "+verificationMessage.getText());
	}

}
