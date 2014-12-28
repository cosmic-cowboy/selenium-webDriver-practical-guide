package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

// WebDriverEventListenerを実装する
public class ImplementsEventListener implements WebDriverEventListener{

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("ImplementsEventListener: After Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("ImplementsEventListener: After Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("ImplementsEventListener: Before Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("ImplementsEventListener: Before Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
