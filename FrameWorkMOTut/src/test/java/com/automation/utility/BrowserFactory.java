package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

		public static WebDriver startApplication(WebDriver driver, String browserName, String url)
		{
			if(browserName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			else if(browserName.equalsIgnoreCase("Edge"))
			{
				System.setProperty("webdriver.edge.driver", ".//Drivers//msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else
				System.out.println("We do not support such browser");
			
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;
			
		}
		
		public static void quiteBrowser(WebDriver driver)
		{
			driver.quit();
		}
}
