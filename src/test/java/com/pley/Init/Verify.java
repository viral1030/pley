package com.pley.Init;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Verify {

	StringBuffer errorString;
	WebDriver driver;
	public Verify() {
		// TODO Auto-generated constructor stub
	errorString=new StringBuffer();
	driver=this.driver;
	}
	
	//call this method instead of assert.asserttrue so that though test fails at some time our whole test suite will execute
	//and later just solve the error messages and thats it
	public void verifyTrue(String msg,Boolean b)
	{
		try {
			Assert.assertTrue(b.booleanValue());
		} catch (Exception e) {
			// TODO: handle exception
			errorString.append(e);
			Reporter.log(msg+"<br/>");
		}
	}
	
}
