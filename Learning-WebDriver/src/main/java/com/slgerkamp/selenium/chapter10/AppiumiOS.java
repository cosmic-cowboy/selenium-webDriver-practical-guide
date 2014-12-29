package com.slgerkamp.selenium.chapter10;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.slgerkamp.selenium.lib.Utils;

public class AppiumiOS {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "8.1");
		desiredCapabilities.setCapability("deviceName", "iPhone 4s");
		desiredCapabilities.setCapability("browserName", "Safari");
		URL url = new URL(Utils.getProperty("appiumUrl") + "wd/hub");
		
		WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);
		driver.get("http://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		driver.quit();
	}
}
