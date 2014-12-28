package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RegisterMultiEventListener {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		// イベントリスナーのインスタンス生成
		ImplementsEventListener implementsEventListener = new ImplementsEventListener();
		ExtendsEventListener extendsEventListener = new ExtendsEventListener();
		
		eventDriver.register(implementsEventListener);
		eventDriver.register(extendsEventListener);
		
		// イベントの実行と検証
		eventDriver.get("http://www.google.com");
		eventDriver.get("http://www.facebook.com");
		eventDriver.navigate().back();
	}
}
