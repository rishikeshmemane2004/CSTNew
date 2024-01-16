package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;

public class PIMPage extends BasePage
{
	private static final By AddCustomer = By.xpath("//div[@id='app']//div[2]/div[1]/button");
	
	public AddCustomerPage clickOnAddCustomer()
	{
		click(AddCustomer, WaitStrategy.CLICKABLE, "ADD CUSTOMER BUTTON");
		return new AddCustomerPage();
	}

}
