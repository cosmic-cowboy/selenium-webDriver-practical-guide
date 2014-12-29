package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.slgerkamp.selenium.lib.Utils;

public class AdminLoginPage {

	WebDriver driver;
	@FindBy(id="user_login")
	WebElement email;
	@FindBy(id="user_pass")
	WebElement pass;
	@FindBy(how=How.ID, using="wp-submit")
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
