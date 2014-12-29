package com.slgerkamp.selenium.chapter09;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.slgerkamp.selenium.lib.Utils;

public class TestAddNewPostUsingPageObject {
	public static void main(String[] args) {
		String timestamp = new Date().toString();
		WebDriver driver = new FirefoxDriver();

		// wordpressの管理画面にアクセス
		AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		// 管理画面にログイン
		adminLoginPage.login(
				Utils.getProperty("wordpressAdminId"), 
				Utils.getProperty("wordpressAdminPass"));
		
		// 投稿一覧画面にアクセス
		AdminAllPostsPage adminAllPostsPage = PageFactory.initElements(driver, AdminAllPostsPage.class);
		// 新しいポストを追加
		adminAllPostsPage.createNewPost("タイトル" + timestamp, "内容" + timestamp);
	}
}
