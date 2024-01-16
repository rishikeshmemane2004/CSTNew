package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;

public class AddCustomerPage extends BasePage 
{
	private static final By userName   = By.name("firstName");
	private static final By middleName = By.name("middleName");
	private static final By lastName   = By.name("lastName");
	private static final By BtnSave    = By.xpath("//div[@id='app']//form/div[2]/button[2]");
	private static final By confirmationMsg = By.xpath("//*[text()='Successfully Saved']");
	
	public String getConfirmationMsg()
	{
		return DriverManager.getDriver().findElement(confirmationMsg).getText();
		
	}
	public void enterUserName(String un)
	{
		sendKeys(userName, un, WaitStrategy.PRESENCE, "USERNAME FIELD");
	}
	public void enterMiddleName(String mn)
	{
		sendKeys(middleName, mn, WaitStrategy.PRESENCE, "USERNAME FIELD");
	}
	public void enterLastName(String ln)
	{
		sendKeys(lastName, ln, WaitStrategy.PRESENCE, "LASTNAME FIELD");
	}
	public void clickOnSaveBtn()
	{
		click(BtnSave, WaitStrategy.CLICKABLE, "SAVE BUTTON");
	}

	




}
