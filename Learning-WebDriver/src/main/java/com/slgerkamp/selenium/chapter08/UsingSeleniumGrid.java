package com.slgerkamp.selenium.chapter08;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.slgerkamp.selenium.lib.Utils;

public class UsingSeleniumGrid {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		
		// Selenium Gridのハブにリクエストを発行
		String url = "http://" + Utils.getProperty("hubRemoteWebDriverUrl") + "/wd/hub";
		RemoteWebDriver remoteWebDriver = 
				new RemoteWebDriver(
						new URL(url), capabilities);
		
		remoteWebDriver.get("http://google.com");
		
		WebElement searchBox = remoteWebDriver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
	}
}
