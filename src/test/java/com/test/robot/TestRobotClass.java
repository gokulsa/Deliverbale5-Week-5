package com.test.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRobotClass 
{
	//Keyboard Pressing Actions
	@Test(priority = 1, description = "First TestCase")
	public void RobotClassKeyboardActions() throws InterruptedException, AWTException
	{
		//Executing the robot class in firefox browser such as Keyboard Actions
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		//Sample site used for robot class demo
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/pimCsvImport");
		
		//Login to OrangeHrm
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/form/fieldset/ul/li[7]/a")).click();
		Thread.sleep(1000);
		
		//Robot Class
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);	//Press Down Arrow Key
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);		//Press Tab Key
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);	//Press Enter key
		Thread.sleep(5000);
		driver.quit();		//Quiting the browser
	}
	
	//Mouse clicking actions
	@Test(priority = 2, description = "Second TestCase")
	public void MouseActions() throws AWTException, InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		// Create object of Robot class
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mousePress(InputEvent.BUTTON2_MASK);
		robot.mouseRelease(InputEvent.BUTTON2_MASK);
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		Thread.sleep(5000);
		
		//close the browser
		driver.quit();
	}
	
	//Mouse Scrolling
	@Test(priority = 3, description = "Third TestCase")
	public void MouseScrollActions() throws AWTException, InterruptedException
	{
		//setup for browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		//sample site mouse scrolling action
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		Robot robot = new Robot();
		 
		// Window Scrolling using Mousewheel
		robot.mouseWheel(5);
		Thread.sleep(2000);
		robot.mouseWheel(-5);
		Thread.sleep(5000);
		driver.quit();
	}
}
