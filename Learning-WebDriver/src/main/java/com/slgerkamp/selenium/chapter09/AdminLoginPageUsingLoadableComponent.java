package com.slgerkamp.selenium.chapter09;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.slgerkamp.selenium.lib.Utils;

public class AdminLoginPageUsingLoadableComponent extends LoadableComponent<AdminLoginPageUsingLoadableComponent>{

	WebDriver driver;
	@FindBy(id="user_login")
	WebElement email;
	@FindBy(id="user_pass")
	WebElement pass;
	@FindBy(how=How.ID, using="wp-submit")
	WebElement submit;
	private final String pageUrl = Utils.getProperty("wordpressUrl") + "wp-login.php";
	
	/**
	 * コンストラクタを用いてインスタンス生成時に
	 * ページヘのアクセスと必要な要素の修得を完了させる
	 * @param driver
	 */
	public AdminLoginPageUsingLoadableComponent(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * ログイン処理
	 * @param emailStr：ログインID
	 * @param passStr：パスワード
	 */
	public AdminAllPostsPage login(String emailStr, String passStr){
		email.click();
		email.sendKeys(emailStr);
		pass.click();
		pass.sendKeys(passStr);
		submit.click();
		return PageFactory.initElements(driver, AdminAllPostsPage.class);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().contains("wp-login"));
	}

	@Override
	protected void load() {
		driver.get(pageUrl);
	}
	
	
}
