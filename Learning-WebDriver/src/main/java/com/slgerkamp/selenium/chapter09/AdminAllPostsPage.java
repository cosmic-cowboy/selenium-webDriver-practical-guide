package com.slgerkamp.selenium.chapter09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.slgerkamp.selenium.lib.Utils;

public class AdminAllPostsPage {

	WebDriver driver;
	
	@FindBy(id="the-list")
	WebElement postsContainer;
	
	@FindBy(id="post-search-input")
	WebElement searchPosts;

	@FindBy(id="cat")
	WebElement viewByCategories;

	private final String pageUrl = Utils.getProperty("wordpressUrl") + "wp-admin/edit.php";

	
	public AdminAllPostsPage(WebDriver driver){
		this.driver = driver;
		driver.get(pageUrl);
	}
	
	public void createNewPost(String titleStr, String description){
		driver.findElement(By.linkText("新規追加")).click();
		// 新しいタイトルを追加
		WebElement title = driver.findElement(By.id("title"));
		title.click();
		title.sendKeys(titleStr);
		// 新しい内容を追加
		WebElement contentArea = driver.findElement(By.id("content_ifr"));
		driver.switchTo().frame(contentArea); 
		WebElement content = driver.findElement(By.id("tinymce"));
		content.click();
		content.sendKeys(description);

		// トップレベルに戻る
		driver.switchTo().defaultContent();

		// ポストを公開
		driver.findElement(By.id("publish")).click();
		
	}

	public void editPost(String title){
		
	}

	public void deletePost(String title){
		
	}
	
	public void filterPostsByCategory(String category){
		
	}
	
	public void searchInPosts(String searchText){
		
	}


}
