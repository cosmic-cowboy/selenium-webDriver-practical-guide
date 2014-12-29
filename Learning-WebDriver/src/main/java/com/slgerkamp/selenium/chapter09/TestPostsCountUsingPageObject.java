package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.slgerkamp.selenium.lib.Utils;

public class TestPostsCountUsingPageObject {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		// 管理画面にログイン
		AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.login(
				Utils.getProperty("wordpressAdminId"), 
				Utils.getProperty("wordpressAdminPass"));

		// 投稿一覧画面に移動し、投稿数をカウントする
		AdminAllPostsPage adminAllPostsPage = PageFactory.initElements(driver, AdminAllPostsPage.class);
		System.out.println("投稿数：" + adminAllPostsPage.getAllPostsCount());
	}
}
