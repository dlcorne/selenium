package com.ex.selenny.pommel;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#acceptCookieButton"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#view-constituents > ul > li:nth-child(2) > a"))).click();
		WinnersPage winnerPage = PageFactory.initElements(this.driver, WinnersPage.class);
		String winnerResult = winnerPage.getWinnerResult();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#content_div_40583 > ul > li:nth-child(3) > a"))).click();
		LosersPage loserPage = PageFactory.initElements(this.driver, LosersPage.class);
		String loserResult = loserPage.getLoserResult();
		
		assertEquals("RS Group plc", winnerResult);
		assertEquals("Haleon plc", loserResult);
	}
	
	@AfterEach
	void teardown() {
		this.driver.close();
	}
}