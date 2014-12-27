package com.slgerkamp.selenium.chapter03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverNavigator {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("titanium");
		searchBox.submit();

		driver.navigate().to("http://www.google.com");
		WebElement searchBox2 = driver.findElement(By.name("q"));
		searchBox2.clear();
		searchBox2.sendKeys("selenium");
		searchBox2.submit();

		// 戻る
		driver.navigate().back();
		// 進む
		driver.navigate().forward();
		// 更新
		driver.navigate().refresh();
	}
}
