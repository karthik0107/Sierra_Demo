package com.sierra.stepDefinitions;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sierra.testbase.BrowserLaunch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OutLook_Login extends BrowserLaunch{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("User navigate to outlook portal Login page")
	public void user_navigate_to_outlook_portal_login_page() throws FileNotFoundException, InterruptedException {
		//BrowserLaunch.Browserlunch();
		driver.get("https://login.live.com/");
		driver.manage().window().maximize();
	}

	@When("User enters valid email address for login outlook portal {string}")
	public void user_enters_valid_email_address_for_login_outlook_portal(String emailid) {
		driver.findElement(By.id("i0116")).sendKeys(emailid);
	}

	@When("Clicks on Next button")
	public void clicks_on_next_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
			
	}
	@When("Ueer enters valid password for outlook {string}")
	public void ueer_enters_valid_password_for_customer_portal(String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))).sendKeys(password);
	}
	@When("Clicks on Login button for outlook")
	public void clicks_on_login_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
	}
	@When("Clicks on Yes button")
	public void clicks_on_yes_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9"))).click();
	}

	@When("Clicks on Menu button")
	public void clicks_on_menu_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"O365_MainLink_NavMenu\"]"))).click();
	}
	@When("Clicks on Outlook")
	public void clicks_on_outlook() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("O365_AppTile_Mail"))).click();
	}

	@SuppressWarnings("deprecation")
	@Then("User should login successfully")
	public void user_should_login_successfully() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Successful");
		}
	@Then("Clicks on Search")
	public void clicks_on_search() throws InterruptedException {
		Thread.sleep(6000);
		Set<String> Windows =driver.getWindowHandles();
        Iterator<String> Itr=Windows.iterator();
		@SuppressWarnings("unused")
		String Parent = Itr.next();
        String Child1=Itr.next();
        Thread.sleep(6000);
        driver.switchTo().window(Child1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topSearchInput"))).click();
	}
	
	@Then("Search the Workorder Id {string}")
	public void search_the_workorder_id(String OrderID) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topSearchInput"))).sendKeys(OrderID);
	}

	@Then("Clicks on Workorder Id")
	public void clicks_on_workorder_id() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rSCR0"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Click this link to create the packing list for Order Number:']/following-sibling::a"))).click();
		System.out.println("Order Details Open Successfully");		
		
		/*
		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"searchSuggestion-0\"]/div/div"));
		Thread.sleep(1000);
		elementToClick.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//b[text()='Click this link to create the packing list for Order Number:']/following-sibling::a")).click();

		*/
		Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles);

		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(7000);
		// CCI form click the updated button 
		WebElement elesendKeys = driver.findElement(By.tagName("h1"));
		elesendKeys.getText();
		System.out.println(elesendKeys.getText());		
		
		//driver.findElement(By.xpath("//ion-col[@ng-reflect-size='8']//button[1]")).click();
		driver.findElement(By.cssSelector("ion-row#submit_btns>ion-col>button")).click();
		

	}
}