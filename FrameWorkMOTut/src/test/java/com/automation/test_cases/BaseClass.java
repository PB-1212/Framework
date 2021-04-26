package com.automation.test_cases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver=null;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(".//Reports//freecrm"+Helper.getCurrentDateTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser_pom", "url_pom"})
	@BeforeClass
	public void setup(String browser, String url)
	{
		//driver = BrowserFactory.startApplication(driver,config.getBrowser(), config.getStringURL());
		driver = BrowserFactory.startApplication(driver,browser, url);
		
	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quiteBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
	
}
