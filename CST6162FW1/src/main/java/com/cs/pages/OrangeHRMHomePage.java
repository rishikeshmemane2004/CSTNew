package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitStrategy;
import com.cs.reports.ExtentLogger;
import com.cs.reports.ExtentManager;

public final class OrangeHRMHomePage extends BasePage{

	private static final By profilePicArrow = By.xpath("//*[@id='app']//header//ul/li/span/img");
	private static final By optionLogout    = By.xpath("(//a[@role='menuitem'])[4]");
	private static final By optionPIM       = By.xpath("//*[@id='app']//li[2]/a");
	
	public PIMPage clickOPtionPIM()
	{
		click(optionPIM, WaitStrategy.CLICKABLE, "PIM OPTION");
		return new PIMPage();
	}
	public OrangeHRMHomePage clickOnProfilePicArrow()
	{
		click(profilePicArrow, WaitStrategy.CLICKABLE,"PROFILE PIC");
		return this;
	}
	
	public OrangeHRMLoginPage clickOnLogoutOption()
	{
		click(optionLogout,WaitStrategy.CLICKABLE,"LOGOUT");
		return new OrangeHRMLoginPage();
	}
}
