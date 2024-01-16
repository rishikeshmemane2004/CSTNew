package com.cs.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.driver.Driver;
import com.cs.reports.ExtentReport;

public class BaseTest 
{
	protected BaseTest(){}

	@BeforeSuite
	public void beforesuite()
	{
		ExtentReport.initReports();
	}
	@AfterSuite
	public void afterSuite()
	{
		ExtentReport.flushReport();
	}
	
	
	@BeforeMethod
	protected void setUp() throws Exception
	{
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown()
	{
		Driver.quitDriver();
	}
	
	
}
