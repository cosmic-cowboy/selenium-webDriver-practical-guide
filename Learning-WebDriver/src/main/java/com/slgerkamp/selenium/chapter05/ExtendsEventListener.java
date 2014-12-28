package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class ExtendsEventListener extends AbstractWebDriverEventListener{
	// 必要な処理だけ拡張する
	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("extendsEventListener: After Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());
		
	}
	
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("extendsEventListener: After Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("extendsEventListener: Before Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());		
	}
	
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("extendsEventListener: Before Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());
	}
}
