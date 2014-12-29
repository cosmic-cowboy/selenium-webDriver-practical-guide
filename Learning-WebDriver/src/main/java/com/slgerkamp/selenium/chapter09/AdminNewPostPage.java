package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminNewPostPage {

	WebDriver driver;
	
	@FindBy(id="title")
	WebElement title;

	@FindBy(id="content_ifr")
	WebElement contentArea;
	
	@FindBy(id="tinymce")
	WebElement content;
	
	@FindBy(id="publish")
	WebElement publish;

	public AdminNewPostPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void addNewPost(String titleStr, String description){
		// 新しいタイトルを追加
		title.click();
		title.sendKeys(titleStr);
	
		// 新しい内容を追加
		driver.switchTo().frame(contentArea); 
		content.click();
		content.sendKeys(description);
	
		// トップレベルに戻る
		driver.switchTo().defaultContent();
	
		// ポストを公開
		publish.click();
	}
}
