package com.slgerkamp.selenium.chapter01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendKeys_Clear_Submit {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		WebElement searchBox = driver.findElement(By.id("lst-ib"));

		// 小文字で入力
		searchBox.sendKeys("selenium");

		// 入力文字をクリア
		searchBox.clear();

		// 大文字で入力
		// 特殊キーはenumクラスにある
		// https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/Keys.html
		searchBox.sendKeys(Keys.chord(Keys.SHIFT, "selenium"));

		// 1文字削除
		searchBox.sendKeys(Keys.BACK_SPACE);

		// submit フォームに対して実行されるアクション
		// フォームでない場所であると、NoSuchElementException
		searchBox.submit();		

	}
}
