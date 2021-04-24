package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	@FindBy (name="email")
	WebElement emailidTxt;
	
	@FindBy (name ="password1")
	WebElement passwordTxt;
	
	@FindBy (xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;

	public void loginToCRM(String emailid, String password) throws InterruptedException {
		Thread.sleep(500);
		emailidTxt.sendKeys(emailid);
		Thread.sleep(500);
		passwordTxt.sendKeys(password);
		Thread.sleep(500);
		loginButton.click();
		
	}
}
