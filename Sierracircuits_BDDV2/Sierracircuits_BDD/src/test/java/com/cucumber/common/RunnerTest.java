package com.cucumber.common;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				
		plugin = { "pretty", 
				"json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumberreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = { "src/test/resources/features" }, 
		glue = {"com.sierra.stepDefinitions" ,  "com.cucumber.common"},
		tags = ("@SmokeTest"),
		monochrome = true 
		
)


public class RunnerTest {
	

}
