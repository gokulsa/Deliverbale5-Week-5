package com.test.dynamictable;



import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestWebTable {

	public static void main(String args[])
	{
		String maximum;
		double m=0,r=0;
		WebDriver wd;
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("http://demo.guru99.com/test/web-table-element.php");

		List <WebElement> column = wd.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]"));
		System.out.println("Total number of columns"+ column.size());
		List <WebElement> row = wd.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td[1]"));
		System.out.println("Total number of rows"+ row.size());
		for(int i=2;i<=4;i++)
		{
			for(int j=1;j<row.size();i++)
			{
				maximum = wd.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+(j+1)+"]/td[i]").getText;
				NumberFormat f = NumberFormat.getNumberInstance();
				Number num = f.parse(maximum);
				maximum = num.toString();
				m=Double.parseDouble(maximum);
				if(m>r)
				{
					r=m;
				}
				System.out.println("MAXIMUM OF "+2+" COLUMN is:"+r);
			}
		}
		wd.close();
	}
}