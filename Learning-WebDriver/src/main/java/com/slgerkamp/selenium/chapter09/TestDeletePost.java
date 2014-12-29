package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class TestDeletePost {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		// 管理画面にログイン
		driver.get(Utils.getProperty("wordpressUrl") + "wp-admin");
		WebElement email  = driver.findElement(By.id("user_login"));
		WebElement pass   = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		
		email.click();
		email.sendKeys(Utils.getProperty("wordpressAdminId"));
		pass.click();
		pass.sendKeys(Utils.getProperty("wordpressAdminPass"));
		submit.submit();
		
		// 投稿一覧画面に移動
		driver.get(Utils.getProperty("wordpressUrl") + "wp-admin/edit.php");
		// 削除対象の投稿編集画面に移動
		driver.findElement(By.id("the-list")).findElement(By.className("row-title")).click();
		// 投稿をゴミ箱に移動
		driver.findElement(By.cssSelector("#delete-action>.submitdelete")).click();
		
	}
}
