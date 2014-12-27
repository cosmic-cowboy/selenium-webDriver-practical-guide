package com.slgerkamp.selenium.chapter01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchPageByTagName {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		List<WebElement> searchBox = driver.findElements(By.tagName("button"));
		
		System.out.println(searchBox.size());

	}
}
