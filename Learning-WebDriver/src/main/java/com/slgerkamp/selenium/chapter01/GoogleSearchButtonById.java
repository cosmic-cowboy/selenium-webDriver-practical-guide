package com.slgerkamp.selenium.chapter01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchButtonById {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.sendKeys("selenium");
		searchBox.submit();		

	}
}
