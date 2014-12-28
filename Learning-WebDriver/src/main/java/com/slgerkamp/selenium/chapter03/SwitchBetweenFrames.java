package com.slgerkamp.selenium.chapter03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class SwitchBetweenFrames {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get(Utils.getProperty("framesUrl"));
		
		driver.switchTo().frame(0);
		WebElement frame1_txt = driver.findElement(By.name("1"));
		frame1_txt.sendKeys("こちらはフレーム１");
		
		// トップレベルのコンテナに戻る
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement frame2_txt = driver.findElement(By.name("2"));
		frame2_txt.sendKeys("こちらはフレーム２");
	}
}
