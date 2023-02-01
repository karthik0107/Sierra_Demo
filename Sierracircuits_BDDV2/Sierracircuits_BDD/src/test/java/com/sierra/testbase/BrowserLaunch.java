package com.sierra.testbase;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.reusable.propertyfile.ReusablePropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserLaunch {
	
	public static WebDriver driver; 
	static ReusablePropertiesFile re;
		
	@SuppressWarnings("deprecation")
	@BeforeTest	
	public static void Browserlunch() throws FileNotFoundException, InterruptedException {
	re=new ReusablePropertiesFile(System.getProperty("user.dir")+"\\src\\test\\resources\\extent.properties");
	if(re.getValuefromPropertyFile("browsername").equalsIgnoreCase("Chrome")) {	
	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	  //  driver.get("https://login.live.com/");
	}else if(re.getValuefromPropertyFile("browsername").equalsIgnoreCase("firefox")) {	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.get("https://accounts.google.com/");
	}else if(re.getValuefromPropertyFile("browsername").equalsIgnoreCase("Edge")) {
	
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	    driver.get("https://accounts.google.com/");
	}
	}
	public static void BrowserClose() {
		driver.close();
	}

}
