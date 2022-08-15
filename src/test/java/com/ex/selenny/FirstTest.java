package com.ex.selenny;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstTest {

	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1280, 720));
	}
	
	@Test
	void theTest() {
		this.driver.get("http://automationpractice.com/index.php");
		driver.get("http://automationpractice.com/index.php");
		WebElement sb = driver.findElement(By.id("search_query_top"));
		String searchTerm = "dress";
		sb.sendKeys(searchTerm);
		sb.submit();
		
		WebElement resultList = driver.findElement(By.cssSelector("#list > a"));
		resultList.submit();
		WebElement topResult = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div"));
		WebElement topResultName = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div > div.center-block.col-xs-4.col-xs-7.col-md-4 > h5 > a"));
		assertEquals(searchTerm, topResultName); // feel like this 1000% doesnt work but i got bigger fish to fry atm
		
		WebElement topResultAtc = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.button-container.col-xs-7.col-md-12 > a.button.ajax_add_to_cart_button.btn.btn-default"));
		topResultAtc.click();
		WebElement checkout = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a"));
		checkout.click();
		WebElement checkout2 = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium"));
		checkout2.click();
		String email = "bruh@bruhmail.ru";
		WebElement emailBar = driver.findElement(By.cssSelector("#email_create"));
		emailBar.sendKeys(email);
		emailBar.submit();
		
		// account page
		String fname = "Bruh";
		String lname = "Bruhson";
		String pwd = "passwordlol";
		String addy = "1738 Fetty Ave";
		String city = "Bruhsville";
		String zip = "80084";
		String mob = "01234567890";
		String addyAlias = "Secret Bunker";
		WebElement fnameBar = driver.findElement(By.cssSelector("#customer_firstname"));
		fnameBar.sendKeys(fname);
		WebElement lnameBar = driver.findElement(By.cssSelector("#customer_lastname"));
		lnameBar.sendKeys(lname);
		WebElement pwdBar = driver.findElement(By.cssSelector("#passwd"));
		pwdBar.sendKeys(pwd);
		WebElement addyBar = driver.findElement(By.cssSelector("#address1"));
		addyBar.sendKeys(addy);
		WebElement cityBar = driver.findElement(By.cssSelector("#city"));
		cityBar.sendKeys(city);
		
		// maybe will not work
		WebElement stateBar = driver.findElement(By.cssSelector("#id_state"));
		stateBar.click();
		stateBar.sendKeys("a");
		stateBar.submit();
		
		WebElement zipBar = driver.findElement(By.cssSelector("#postcode"));
		zipBar.sendKeys(zip);
		WebElement mobBar = driver.findElement(By.cssSelector("#phone_mobile"));
		mobBar.sendKeys(mob);
		WebElement aliasBar = driver.findElement(By.cssSelector("#alias"));
		aliasBar.sendKeys(addyAlias);
		
		// address page
		WebElement checkout3 = driver.findElement(By.cssSelector("#center_column > form > p > button"));
		checkout3.click();
		
		// shipping page
		WebElement tos = driver.findElement(By.cssSelector("#cgv"));
		tos.click();
		WebElement checkout4 = driver.findElement(By.cssSelector("#form > p > button"));
		checkout4.click();
		
		// payment page
		WebElement wire = driver.findElement(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"));
		wire.click();
		WebElement checkout5 = driver.findElement(By.cssSelector("#cart_navigation > button"));
		checkout5.click();
		
	}
	
	@AfterEach
	void teardown() {
		this.driver.close();
	}
}
