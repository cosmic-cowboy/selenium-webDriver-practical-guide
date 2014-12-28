package com.slgerkamp.selenium.chapter03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWaitTime {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		WebElement element = (new WebDriverWait(driver, 20))
				.until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name("q"));
					}
		});
		element.sendKeys("selenium");
		element.submit();
	}
}
