package com.slgerkamp.selenium.continuous_integration;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToUrlTest {
	
	private WebDriver driver;

	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void Googleにアクセスする(){
		driver.get("https://www.google.com");		
		List<WebElement> searchBoxList = driver.findElements(By.id("lst-ib"));
		assertThat(searchBoxList.size(), is(1));
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
}
