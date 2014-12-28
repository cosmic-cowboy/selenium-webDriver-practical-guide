package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ConfirmEventListener {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		
		ImplementsEventListener implementsEventListener = new ImplementsEventListener();
		
		eventFiringWebDriver.register(implementsEventListener);
		
		// イベントの実行と検証
		eventFiringWebDriver.get("https://google.com/");
		eventFiringWebDriver.get("https://twitter.com/");
		eventFiringWebDriver.navigate().back();
		eventFiringWebDriver.navigate().forward();
		// ID
		WebElement signinEmail = eventFiringWebDriver.findElement(By.id("signin-email"));
		signinEmail.sendKeys("id");
		// PASS
		WebElement signinPassword = eventFiringWebDriver.findElement(By.id("signin-password"));
		signinPassword.sendKeys("pass");
		// Login
		WebElement signin = eventFiringWebDriver.findElement(By.className("js-submit"));
		signin.click();
		eventFiringWebDriver.executeScript("alert('hello world');");
	}
}
