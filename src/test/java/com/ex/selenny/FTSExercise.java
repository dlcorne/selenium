package com.ex.selenny;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FTSExercise {

	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1280, 720));
	}
	
	@Test
	void daTest() { 
		this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#view-constituents > ul > li:nth-child(2) > a"))).click();
		
		WebElement top1 = driver.findElement(By.cssSelector("#ls-row-RS1-L > td.name-col.align-left > a"));
		
		
		
		WebElement bot = driver.findElement(By.cssSelector("#content_div_40583 > ul > li:nth-child(3) > a"));
		bot.click();
		WebElement bot1 = driver.findElement(By.cssSelector("#ls-row-HLN-L > td.name-col.align-left > a"));
		
	}
	
	@AfterEach
	void teardown() {
		this.driver.close();
	}
}