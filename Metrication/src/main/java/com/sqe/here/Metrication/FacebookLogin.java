package com.sqe.here.Metrication;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FacebookLogin 
{
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test(priority=2)
	public void visitFacebookHomepage()
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @name='pass']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		WebElement ele=driver.findElement(By.xpath("//*[@title='Profile']"));
		Assert.assertEquals("//*[@title='Profile']", ele);
	}
	
	@Test(priority=1)
	public void gmailLogin()
	{
		driver.get("https://accounts.google.com/ServiceLogin");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("prerana.aug@gmail.com");
		
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
