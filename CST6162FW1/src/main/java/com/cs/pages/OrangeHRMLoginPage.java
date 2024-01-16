package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;

public class OrangeHRMLoginPage extends BasePage{

	private static final By userName = By.name("username");
	private static final By password = By.name("password");
	private static final By btnLogin = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginPage enterUsername(String un) {
		sendKeys(userName, un, WaitStrategy.PRESENCE,"USERNAME");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String pw) {
		sendKeys(password, pw,WaitStrategy.PRESENCE,"PASSWORD");
		return this;
	}

	public OrangeHRMHomePage clickOnLoginBtn() {
		click(btnLogin,WaitStrategy.CLICKABLE, "LOGINBUTTON");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
