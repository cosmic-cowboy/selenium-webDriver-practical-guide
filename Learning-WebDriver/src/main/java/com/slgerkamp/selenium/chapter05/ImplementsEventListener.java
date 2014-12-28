package com.slgerkamp.selenium.chapter05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

// WebDriverEventListenerを実装する
public class ImplementsEventListener implements WebDriverEventListener{

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: after change value " + element
	               +driver.getCurrentUrl());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: after click element " + element
	               +driver.getCurrentUrl());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: after find element " + element
				+ ", by " + by
	            + driver.getCurrentUrl());
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("ImplementsEventListener: After Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("ImplementsEventListener: After Navigate Forward. Right now I'm at "
	               +driver.getCurrentUrl());
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("ImplementsEventListener: After Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println("ImplementsEventListener: After script " + script
	               +driver.getCurrentUrl());
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: before change value " + element
	               +driver.getCurrentUrl());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: before click element " + element
	               +driver.getCurrentUrl());
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("ImplementsEventListener: before find element " + element
				+ ", by " + by
	            + driver.getCurrentUrl());
	}


	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("ImplementsEventListener: Before Navigate Back. Right now I'm at "
	               +driver.getCurrentUrl());		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("ImplementsEventListener: Before Navigate Forward. Right now I'm at "
	               +driver.getCurrentUrl());		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("ImplementsEventListener: Before Navigate To: "+url
				+" and Current url is: "+driver.getCurrentUrl());
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("ImplementsEventListener: before script " + script
	               +driver.getCurrentUrl());
	}

	@Override
	public void onException(Throwable err, WebDriver driver) {
		System.out.println("ImplementsEventListener: Error " + err
	               +driver.getCurrentUrl());
	}

}
