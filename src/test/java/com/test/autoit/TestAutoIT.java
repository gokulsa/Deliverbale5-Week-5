package com.test.autoit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAutoIT
{
	@Test
	public void UploadFile() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/pimCsvImport");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		
		/*WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("pimCsvImport_csvFile")));*/
		// To click the upload file button
		WebElement clickchoose = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[@id='pimCsvImport']/div[2]/form[1]/fieldset[1]/ol[1]/li[1]/label[1]"));
		clickchoose.click();
		Thread.sleep(5000);

		Runtime.getRuntime().exec("D:\\OrangeUploadScript.exe");	//scite script exe file path
		
		Thread.sleep(10000);
		driver.findElement(By.id("btnSave")).click();

		Thread.sleep(3000);
		driver.quit();
	}
}
