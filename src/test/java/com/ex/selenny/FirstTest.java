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
		
		// Here I'd be looking at the results page of the site and asserting that searchTerm is somewhere within the name of the top result.
		// Yet the site is exceeding resource limit and does not process search requests, so, little hard to do that.
		// Can only assume this is the result of what you said about someone accessing it too much?
		
		WebElement result = driver.findElement(By.cssSelector(null)); // null would be the resulting dress
		assertEquals(searchTerm, result.getText()); // not exactly like this probably but without trial and error i am nothing
			
	}
	
	@AfterEach
	void teardown() {
		this.driver.close();
	}
}
