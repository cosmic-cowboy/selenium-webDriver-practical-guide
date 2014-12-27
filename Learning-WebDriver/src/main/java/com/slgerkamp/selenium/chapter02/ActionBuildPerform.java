package com.slgerkamp.selenium.chapter02;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.slgerkamp.selenium.lib.Utils;

public class ActionBuildPerform {

	public static void main(String[] args) {

		
		WebDriver driver = new FirefoxDriver();
		driver.get(Utils.getProperty("selectableUrl"));
		WebElement one = driver.findElement(By.name("one")); 
		WebElement three = driver.findElement(By.name("three")); 
		WebElement five = driver.findElement(By.name("five")); 
		
		// アクションの生成
		Actions builder = new Actions(driver) ;
		builder.keyDown(Keys.CONTROL)
			.click(one)
			.click(three)
			.click(five)
			.keyUp(Keys.CONTROL);

		// アクションの実行
		// ビルドはperformが内部的に実行する
		builder.perform();
	}
}
