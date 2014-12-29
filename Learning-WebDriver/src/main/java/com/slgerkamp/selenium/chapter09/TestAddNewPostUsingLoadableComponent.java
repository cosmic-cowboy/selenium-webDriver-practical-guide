package com.slgerkamp.selenium.chapter09;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.slgerkamp.selenium.lib.Utils;

public class TestAddNewPostUsingLoadableComponent {
	public static void main(String[] args) {
		String timestamp = new Date().toString();
		WebDriver driver = new FirefoxDriver();

		// wordpressの管理画面にアクセス
		AdminLoginPageUsingLoadableComponent adminLoginPage = 
				new AdminLoginPageUsingLoadableComponent(driver).get();
		// 管理画面にログインして、投稿一覧画面にアクセス
		AdminAllPostsPage adminAllPostsPage = adminLoginPage.login(
				Utils.getProperty("wordpressAdminId"), 
				Utils.getProperty("wordpressAdminPass"));
		
		// 新しいポストを追加
		adminAllPostsPage.createNewPost("タイトル" + timestamp, "内容" + timestamp);
	}
}
