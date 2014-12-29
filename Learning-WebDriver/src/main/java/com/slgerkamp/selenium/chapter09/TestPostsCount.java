package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class TestPostsCount {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		// 管理画面にログイン
		driver.get(Utils.getProperty("wordpressUrl") + "wp-admin");
		WebElement email  = driver.findElement(By.id("user_login"));
		WebElement pass   = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		email.sendKeys(Utils.getProperty("wordpressAdminId"));
		pass.sendKeys(Utils.getProperty("wordpressAdminPass"));
		submit.click();

		// 投稿一覧画面に移動
		driver.get(Utils.getProperty("wordpressUrl") + "wp-admin/edit.php");
		// 投稿数をカウントする
		System.out.println("投稿数：" + driver.findElement(By.id("the-list")).findElements(By.tagName("tr")).size());
	}
}
