package com.slgerkamp.selenium.chapter03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class WindowHandling {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		// ひとつ目のウィンドウが立ち上がる
		driver.get(Utils.getProperty("windowUrl"));
		
		String window1 = driver.getWindowHandle();
		System.out.println("First Window Handle is " + window1);
		WebElement link = driver.findElement(By.linkText("Google 検索"));
		link.click();

		// リンクをクリックしてふたつ目のウィンドウが立ち上がる
		String window2 = driver.getWindowHandle();
		System.out.println("Second Window Handle is " + window2);
		System.out.println("Number of Window Handles so far : " + driver.getWindowHandles().size());
		
		// ひとつ目のウィンドウに戻る
		driver.switchTo().window(window1);
	}
}
