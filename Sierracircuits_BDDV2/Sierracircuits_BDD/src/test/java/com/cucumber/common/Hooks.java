package com.cucumber.common;

import java.io.FileNotFoundException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sierra.testbase.BrowserLaunch;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BrowserLaunch{
	
	
	@Before
	public void setup() throws FileNotFoundException, InterruptedException {
		
		BrowserLaunch.Browserlunch();
		driver.manage().window().maximize();
		System.out.println("Browser launch sucessfulluy");
	}
	
	@After(order = 0)
	public void tearDown() {
		
		System.out.println("Close browser");
		driver.quit();
		
	}
	
	@After(order = 1) // Cucumber After Hook with order 1
	public void takeScreenShotOnFailedScenario(Scenario scenario) {

		//System.out.println("Taking screenshot from Cucumber After hook with order=2 if the scenario fails");
		if ((scenario.isFailed())) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	
	
	
	}
	
	
	
}

