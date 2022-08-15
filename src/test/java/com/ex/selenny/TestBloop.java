package com.ex.selenny;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBloop {

	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1280, 720));
	}
	
	@Test
	void theTest() {
		this.driver.get("http://automationpractice.com/index.php");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement sb = driver.findElement(By.id("search_query_top"));
		String searchTerm = "Printed Summer Dress";
		sb.sendKeys(searchTerm);
		sb.submit();
		
		WebElement resultList = driver.findElement(By.cssSelector("#list > a"));
		resultList.click();
		assertEquals(searchTerm, this.driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div > div.center-block.col-xs-4.col-xs-7.col-md-4 > h5 > a")).getText()); 
		
		//add to cart
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#center_column > ul > li:nth-child(1) > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.button-container.col-xs-7.col-md-12 > a.button.ajax_add_to_cart_button.btn.btn-default")))).click();
		
		//go to checkout process
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")))).click();
		
		//go to login
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")))).click();
		
		String email = "bruh@bruhmail.ru";
		String pwd = "passwordlol";
		WebElement login = driver.findElement(By.id("email"));
		login.sendKeys(email);
		WebElement pswd = driver.findElement(By.id("passwd"));
		pswd.sendKeys(pwd);
		pswd.submit();
		
		// address page
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > form > p > button > span"))).click();
		
		// shipping page
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > p.checkbox > label"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > p > button > span"))).click();
		
		// payment page
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart_navigation > button"))).click();
		
		
	}
	
	@AfterEach
	void teardown() {
		this.driver.close();
	}
}
