package com.slgerkamp.selenium.chapter09;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class TestAddNewPost {
	public static void main(String[] args) {
		String timestamp = new Date().toString();
		WebDriver driver = new FirefoxDriver();
		String url = Utils.getProperty("wordpressUrl") + "wp-admin";
		// wordpressの管理画面にアクセス
		driver.get(url);
		// 管理画面にログイン
		WebElement email  = driver.findElement(By.id("user_login"));
		WebElement pass   = driver.findElement(By.id("user_pass"));
		WebElement submit = driver.findElement(By.id("wp-submit"));
		email.sendKeys(Utils.getProperty("wordpressAdminId"));
		pass.sendKeys(Utils.getProperty("wordpressAdminPass"));
		submit.click();
		
		// All　Post ページに移動
		String editurl = Utils.getProperty("wordpressUrl") + "wp-admin/edit.php";
		driver.get(editurl);
		// 新しいポストを追加
		driver.findElement(By.linkText("新規追加")).click();
		// 新しいタイトルを追加
		WebElement title = driver.findElement(By.id("title"));
		title.click();
		title.sendKeys("タイトル" + timestamp);
		// 新しい内容を追加
		WebElement contentArea = driver.findElement(By.id("content_ifr"));
		driver.switchTo().frame(contentArea); 
		WebElement content = driver.findElement(By.id("tinymce"));
		content.click();
		content.sendKeys("内容" + timestamp);

		// トップレベルに戻る
		driver.switchTo().defaultContent();

		// ポストを公開
		driver.findElement(By.id("publish")).click();

	}
}
