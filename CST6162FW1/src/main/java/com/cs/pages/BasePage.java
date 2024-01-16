package com.cs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.constants.Frameworkconstants;
import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;
import com.cs.factories.ExplicitWaitFactory;
import com.cs.reports.ExtentLogger;

public class BasePage {

	protected static void click(By by, WaitStrategy waitStrategy, String elementName)
	{
//		explicitlyWaitforElement(by, waitStrategy);
//		DriverManager.getDriver().findElement(by).click();
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		ExtentLogger.pass(elementName + " clicked");
	}
	protected static void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName)
	{
//		explicitlyWaitforElement(by, waitStrategy);
//		DriverManager.getDriver().findElement(by).sendKeys(data);
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);	 
		element.sendKeys(value);
		ExtentLogger.pass(value + " is entered successfully in " + elementName);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected static void explicitlyWaitforElementToBeClickable(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	private static void explicitlyWaitForElementToBeClickable(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait());
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	private static void explicitlyWaitForElementToBePresent(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait());
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	private static void explicitlyWaitForElementToBeVisible(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	private static void explicitlyWaitforElement(By by, WaitStrategy waitStrategy)
	{
		if (waitStrategy == WaitStrategy.PRESENCE)
			explicitlyWaitForElementToBePresent(by);
		else if (waitStrategy == WaitStrategy.CLICKABLE)
			explicitlyWaitForElementToBeClickable(by);
		else if (waitStrategy == WaitStrategy.VISIBLE)
			explicitlyWaitForElementToBeVisible(by);
	}
	
}
