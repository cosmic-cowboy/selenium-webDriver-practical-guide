package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.slgerkamp.selenium.lib.Utils;

public class AdminLoginPage {

	WebDriver driver;
	WebElement email;
	WebElement pass;
	WebElement submit;
	private final String pageUrl = Utils.getProperty("wordpressUrl") + "wp-admin";
	
	/**
	 * コンストラクタを用いてインスタンス生成時に
	 * ページヘのアクセスと必要な要素の修得を完了させる
	 * @param driver
	 */
	public AdminLoginPage(WebDriver driver){
		this.driver = driver;
		driver.get(pageUrl);
		email  = driver.findElement(By.id("user_login"));
		pass   = driver.findElement(By.id("user_pass"));
		submit = driver.findElement(By.id("wp-submit"));
	}
	
	/**
	 * ログイン処理
	 * @param emailStr：ログインID
	 * @param passStr：パスワード
	 */
	public void login(String emailStr, String passStr){
		email.click();
		email.sendKeys(emailStr);
		pass.click();
		pass.sendKeys(passStr);
		submit.click();
	}
}
