package com.sierra.testbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

public class ReusableSeleniumCommonMethods  extends BrowserLaunch{
	
	
	
	
	public static void url(String URL,String testcasestep){
		driver.get(URL);
	}
	public static String gettingTitlename(String testcasestep){
		
		return driver.getTitle();
	}
	
	public static void mouseHover(By locatorname,String testcasestep){
		
		WebElement ele=driver.findElement(locatorname);
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();	
		
	}
	
	public static void click(By locatorname) {
	
		 driver.findElement(locatorname).click();
	}
	

	public static boolean isDisplayed(By locatorname) {
		boolean status=driver.findElement(locatorname).isDisplayed();
		return status;
	}
	
	public static String getElementText(By locatorname) {
		String text=driver.findElement(locatorname).getText();
		return text;
	}
       
	public static  void sendKey( By locatorname,String enter) {
		driver.findElement(locatorname).clear();
		driver.findElement(locatorname).sendKeys(enter);
		
	}
	public static void select(By locatorname,String question) {
		
      }
	public static  void NewTab( By locatorname,String enter, String url) {
		WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
		newTab.get(url);
		newTab.findElement(locatorname).clear();
		newTab.findElement(locatorname).sendKeys(enter);
	}
	public static  void WindowHandle( By locatorname,String enter, String url) {
		String parent=driver.getWindowHandle();
		WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
		newTab.get(url);
		newTab.findElement(locatorname).clear();
		newTab.findElement(locatorname).sendKeys(enter);
	}
	
	
	public static String captureScreenshot( ) {
		// TODO Auto-generated method stub
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		String Screenshot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot Taken Successfully");
		return Screenshot;
	}
	public static String captureScreenshot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".//Screenshots/"+ fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
		
	}
	}