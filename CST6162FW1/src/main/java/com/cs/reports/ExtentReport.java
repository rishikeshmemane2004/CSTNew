package com.cs.reports;

import java.util.Date;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	private static ExtentReports extent;
	public static ExtentTest test;

	private ExtentReport() {}

	public static void initReports() 
	{
		if (Objects.isNull(extent))
		{
			extent = new ExtentReports();
//			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/resources/extent-reports/" +"index.html");
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/resources/extent-reports/" + new Date().toString().replace(" ", "_").replace(":", "_")+"_index.html");
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Cyber Success Automation");
			spark.config().setReportName("CS Automation Report");
		}
	}
	static public void flushReport()
	{
		if(Objects.nonNull(extent))
			extent.flush();
	}	
	static public void createTest(String testCaseName)
	{
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}

	
	
}
