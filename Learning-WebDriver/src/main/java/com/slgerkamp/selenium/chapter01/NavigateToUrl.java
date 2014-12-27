package com.slgerkamp.selenium.chapter01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToUrl {
	public static void main(String[] args) {
		// WebDriverインタフェースを持つFirefoxの実装をインスタンス化
		WebDriver driver = new FirefoxDriver();
		// 指定したwebページのロードを行う
		driver.get("http://google.com");
	}
}
