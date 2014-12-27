package com.slgerkamp.selenium.chapter03;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakiesScreenShot {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(srcFile.getAbsolutePath());
	}
}
