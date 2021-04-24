package com.automation.test_cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class HomeTestCRM extends BaseClass {

	@Test
	public void homeLoginTest()
	{
		logger=report.createTest("Login to CRM");
		
		HomePage homePage= PageFactory.initElements(driver, HomePage.class);
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
	
		logger.info("Starting Application");
		homePage.clickOnLogin();
		
		logger.info("Login to Application");
		try {
			loginPage.loginToCRM(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.pass("Login Sucsses");
		
		
	
		
	}
}
