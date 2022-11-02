package com.stepDefinition;


import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

import pages.LoginPage;
public class TestSteps {
	static LoginPage loginPg;

	public static WebDriver driver;
	public String expectedOutput= "Hello vasuvespag!";
	@Given("User is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Inside given method");
		System.setProperty("webdriver.chrome.driver", "C:\\Niveditha\\chromedriver102win32\\chromedriver.exe");
		driver= new ChromeDriver();
		//driver.get("https://adactinhotelapp.com");
		driver.get("https://adactinhotelapp.com");
		driver.manage().window().maximize();
		loginPg= new LoginPage(driver);
		System.out.println("Inside hotel app homepage");
	}

	@When("User enters Username")
	public void user_enters_username() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	  //  System.out.println("Inside Username method");
	    //WebElement uname=driver.findElement(By.id("username"));
		//uname.clear();
		//uname.sendKeys("vasuvespag");
		//loginPg= new LoginPage(driver);
		loginPg.enterUserName("vasuvespag");
		System.out.println("Inside username method");
	}

	@When("User enters Password")
	public void user_enters_password() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
//		System.out.println("Inside password method");
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("vasu1234");
	loginPg.enterPassword("vasu1234");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//System.out.println("Inside Login method");
		//driver.findElement(By.className("login_button")).click();
	loginPg.clickLoginBtn();
	
	}

	@Then("Login is successful")
	public void login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Inside then method");
		WebElement greeting= driver.findElement(By.name("username_show"));		
		String actualOutput = greeting.getAttribute("value");
		assertEquals(expectedOutput, actualOutput);
	}
	@When("User selects location from the dropdown")
	public void user_selects_location_from_the_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	    new Select(driver.findElement(By.cssSelector("#location"))).selectByValue("Melbourne");
		
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    driver.findElement(By.name("Submit")).click();
	}

	@Then("list of hotels is displayed")
	public void list_of_hotels_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expectedTitle="Adactin.com - Select Hotel";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@When("User selects a radio button")
	public void user_selects_a_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.xpath("//*[@id=\"radiobutton_4\"]")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	    driver.findElement(By.name("continue")).click();
	}

	@Then("Book a hotel page is displayed")
	public void book_a_hotel_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String expectedTitle="Adactin.com - Book A Hotel";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	@When("User enters username {string}")
	public void user_enters_username_(String string) {
	    // Write code here that turns the phrase above into concrete actions
	 //throw new io.cucumber.java.PendingException();
		System.out.println("Inside Username method");
	    WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

	@When("User enters password {string}")
	public void user_enters_password_(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Inside password method");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}
	@When("User enters Username as <{string}>")
	public void user_enters_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
	uname.sendKeys(string);
	}

	@When("User enters Password as <{string}>")
	public void user_enters_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // new io.cucumber.java.PendingException();
		System.out.println("Inside password method");
		driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys(string);
	}
	
	@When("User enters username and password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable userCredentials) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
//		List<List<String>> data = userCredentials.asLists(String.class);
//		String username=data.get(0).get(0);
//		String password = data.get(0).get(1);
//		WebElement uname=driver.findElement(By.id("username"));
//		uname.clear();
//	uname.sendKeys(username);
//	driver.findElement(By.name("password")).clear();
//	driver.findElement(By.name("password")).sendKeys(password);
		List<Map<String,String>> data=userCredentials.asMaps(String.class,String.class);
		for(Map<String,String> data1:data)
		{
			String username = data1.get("UserName");
			WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(username);
			String password= data1.get("Password");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
			}
		}


}
