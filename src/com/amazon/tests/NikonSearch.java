package com.amazon.tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class NikonSearch {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create firefox driver to drive browser
		
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C://Amazon//chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Open Amazon homepage
		driver.get("http://www.amazon.com");	
		
		//Verify that we are in correct page
		Assert.assertEquals(driver.getPageSource().contains("Amazon.com:"), true);
		
		//Find Search field and enter Nikon
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
		
		//Click find button
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Change list from High to Low
		new Select(driver.findElement(By.id("sort"))).selectByVisibleText("Price: High to Low");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//Find second item from the list
		driver.findElement(By.id("result_1")).click();
		
		//Find "Nikon D3X" from the page
		Assert.assertEquals(driver.getPageSource().contains("Nikon D3X"), true);
		//Will fail since do no exist
		//Exception in thread "main" junit.framework.AssertionFailedError: expected:<false> but was:<true>
	}

}