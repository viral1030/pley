package com.pley.Verification;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pley.Init.Common;

public class verifyElement extends AbstractPage {

	public verifyElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


Common common = new Common(driver);
	
	
	public void verificationMethod(WebElement webElement,String Msg)
	{
		if(common.isElementDisplayed(webElement))
		{
			common.logverification(Msg);
			common.logStatus(PASSED);
		}else
		{
			common.logverification(Msg);
			common.logStatus(FAILED);
		}
		
	}
	
	public void verificationNotNull(WebElement element,String Tabname)
	{
		common.pause(1);
		if(element.getText().equals(null))
		{
			common.log("data not selected for "+ Tabname);
			common.logStatus(FAILED);
		}else
		{
			common.log("data selected Successfully  for "+ Tabname);
			common.logStatus(PASSED);
		}
	}
	
	public void verifytextbox(WebElement element, String tocompare,String msg)
	{
		if(tocompare.equals(element.getAttribute("value")))
		{
			common.logverification(msg);
			common.logStatus(PASSED);
		}else
		{
			//System.out.println(tocompare+" == "+element.getAttribute("value"));
			common.logverification(msg);
			common.logStatus(FAILED);
		}
	}
	
	public void verifyselecteddata(String selected, String toverify,String tabname)
	{
		System.out.println(selected+" == "+toverify);
		if(selected.equals(toverify))
		{
			common.logverification("Selected Data is present on "+tabname+" tab");
			common.logStatus(PASSED);
		}else
		{
			common.logverification("Selected Data is not present on "+tabname+" tab");
			common.logStatus(FAILED);
		}
		
	}
	
	
	

	
/*--------------------------VERIFICATION METHOD------------------------------------------------------------------*/	
	
	public void verification_method(WebElement element,String element_name,String element_type,String page_name)
	{
		
		
		/*Actions move_to_element=new Actions(driver);
		move_to_element.moveToElement(element).build().perform();
		common.pause(3);
		*/

		if (common.isElementDisplayed(element)) {

			common.log("'"+element_name+"' "+element_type+" verification on "+page_name+" page. <h3 style=color:green>PASSED</h3>");
			Assert.assertTrue(true);
		} else {

			common.log("'"+element_name+"' "+element_type+" verification on "+page_name+" page. <h3 style=color:red>FAILED</h3>");

			Assert.assertTrue(false);
		}
		
	}
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	
}
