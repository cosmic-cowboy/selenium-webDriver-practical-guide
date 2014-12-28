package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RegisterEventListener {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		// すべてのユーザのアクションはこのドライバーのインスタンスを使って実行される
		EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
		
		// イベントリスナーのインスタンス生成
		ImplementsEventListener eventListener = new ImplementsEventListener();

		// イベントリスナーにイベントを通知するためEventFiringWebDriverに登録する
		eventFiringDriver.register(eventListener);
		
		// 検証
		eventFiringDriver.get("https://www.google.com");
		eventFiringDriver.get("https://twitter.com");
		eventFiringDriver.navigate().back();
	}
}
