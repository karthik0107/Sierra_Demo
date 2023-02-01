package com.sierra.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.sierra.testbase.BrowserLaunch;

import io.cucumber.java.en.*;

public class login_cp_stepDefini extends BrowserLaunch {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("User navigate to customer portal Login page")
	public void user_navigate_to_customer_portal_login_page() {

		//BrowserLaunch.Browserlunch();
		driver.get("https://staging.protoexpress.com/customer-portal/login/");
		driver.manage().window().maximize();
		
	}

	@When("User enters valid email address for customer portal {string}")
	public void user_enters_valid_email_address_for_customer_portal(String emailid) {

		// User name and password field
		driver.findElement(By.id("username")).sendKeys(emailid);

	}

	@When("Ueer enters valid password for customer portal {string}")
	public void ueer_enters_valid_password_for_customer_portal(String password) {

		driver.findElement(By.id("password")).sendKeys(password);

	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {

		driver.findElement(By.id("btnlogin")).click();

	}

	@Then("Customer Portal user should login successfully")
	public void user_should_login_successfully() {
		System.out.println(">>>User should login successfully");

	}

	@When("the user Navigate to Design RFQ Page")
	public void the_user_Navigate_to_Design_RFQ_Page() {

		// click on the Get q quote for your design page
		WebElement element = driver.findElement(By.linkText("Get a quote for your design"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	@Then("Verify the Design RFQ Page get opend")
	public void verify_the_design_rfq_page_get_opend() throws InterruptedException {

		Thread.sleep(3000);
		// String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		// System.out.println(windowHandles);

		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(3000);
		driver.findElement(By.id("flexRadioDefault1")).click();

	}

}
