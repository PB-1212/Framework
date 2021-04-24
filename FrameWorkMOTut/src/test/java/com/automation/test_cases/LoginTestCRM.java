package com.automation.test_cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utility.ExcelDataProvider;

public class LoginTestCRM extends BaseClass {	
	
	
	@Test
	public void loginAppTest() throws InterruptedException
	{
		ExcelDataProvider excel= new ExcelDataProvider();
	
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToCRM(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		
	}
}
