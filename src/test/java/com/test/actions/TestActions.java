package com.test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActions 
{
	@Test
	public void ActionsClass() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webdriveruniversity.com/Actions/");
		Actions action = new Actions (driver);
		Thread.sleep(3000);
		WebElement element1= driver.findElement(By.id("click-box"));
		Thread.sleep(3000);
		action.clickAndHold(element1).build().perform();
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.id("double-click"));
		action.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		WebElement drag= driver.findElement(By.id("draggable"));
		WebElement drop= driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		WebElement hover = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
		action.moveToElement(hover).build().perform();
		Thread.sleep(3000);
		WebElement rightclick= driver.findElement(By.id("click-box"));
		action.contextClick(rightclick).build().perform();
		Thread.sleep(3000);
		driver.quit();
	}
}
