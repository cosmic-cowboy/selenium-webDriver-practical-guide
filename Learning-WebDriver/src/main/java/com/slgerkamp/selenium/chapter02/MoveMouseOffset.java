package com.slgerkamp.selenium.chapter02;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.slgerkamp.selenium.lib.Utils;

public class MoveMouseOffset {

	public static void main(String[] args) {

		
		WebDriver driver = new FirefoxDriver();
		driver.get(Utils.getProperty("selectableUrl"));
		WebElement three = driver.findElement(By.name("three")); 
		Point point = three.getLocation();
		System.out.println(point);
		// アクションの生成
		Actions builder = new Actions(driver) ;
		builder.moveByOffset(point.getX() + 15, point.getY() + 15).click();

		// アクションの実行
		// ビルドはperformが内部的に実行する
		builder.perform();
	}
}
