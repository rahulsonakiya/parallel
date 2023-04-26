package com.Parallel.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
	
	
	}
	
	
	 public  WebDriver driver;
	
	   
		@BeforeTest
		public void openBrowser()
		{
			Reporter.log("open browser",true);
			driver=new ChromeDriver();
			
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
		}
		
		@AfterTest
		public void closeBrowser()
		{
			Reporter.log("close browser",true);
			driver.close();
		}
		
		@BeforeMethod
		public void login()
		{
			Reporter.log("login",true);
			driver.get("https://demo.actitime.com/");
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.name("pwd")).sendKeys("manager");
			driver.findElement(By.xpath("//div[.='Login ']")).click();
		}
		
		@AfterMethod
		public void logout()
		{
			Reporter.log("logout",true);
			driver.findElement(By.id("logoutLink")).click();
		}
		
		
	

}
