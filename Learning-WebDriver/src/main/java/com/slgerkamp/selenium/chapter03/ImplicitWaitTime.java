package com.slgerkamp.selenium.chapter03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitTime {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		//	https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#manage()
		//	https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Options.html#timeouts()
		//	https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#implicitlyWait(long,%20java.util.concurrent.TimeUnit)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
	}
}
