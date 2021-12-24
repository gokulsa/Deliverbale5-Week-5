package com.test.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavascriptExecutor 
{
	//login to Orange hrm using javascript executor
	@Test(priority = 1, description = "First Test Case")
	public void JavaScriptLogin() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		js.executeScript("document.getElementById('txtUsername').value='Admin';");
		js.executeScript("document.getElementById('txtPassword').value='admin123';");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('btnLogin').click();");
		Thread.sleep(2000);
		js.executeScript("alert('Orange HRM site get opened');");
		Thread.sleep(2000);
		driver.quit();
	}
	//Window scrolling using JavaScriptExecutor
	@Test(priority = 2, description = "Second Test Case")
	public void JavaScriptScroll() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Create an object for JavaScriptExecutor class
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.quit();
	}
	
}
