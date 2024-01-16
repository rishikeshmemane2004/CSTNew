package com.cs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.pages.AddCustomerPage;
import com.cs.pages.OrangeHRMHomePage;
import com.cs.pages.OrangeHRMLoginPage;
import com.cs.pages.PIMPage;

public class CustomerTests extends BaseTest 
{

	@Test
	public void addCustomer()
	{
	// Login to application 
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		OrangeHRMHomePage ohhp = ohlp.enterUsername("Admin").enterPassword("admin123").clickOnLoginBtn();
		
		PIMPage pp = ohhp.clickOPtionPIM();
		AddCustomerPage acp = pp.clickOnAddCustomer();
		acp.enterUserName("Cyber_" + System.currentTimeMillis());
		acp.enterMiddleName("Success_" + System.currentTimeMillis());
		acp.enterLastName("Training_" + System.currentTimeMillis());
		acp.clickOnSaveBtn();
		 
		String actConfirmationMsg = acp.getConfirmationMsg();
		String expConfirmationMsg = "Successfully Saved";
		Assert.assertEquals(actConfirmationMsg, expConfirmationMsg,"Customer did not save successfully !");
	
		
	
	}
	
}
