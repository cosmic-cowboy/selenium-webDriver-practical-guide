package com.slgerkamp.selenium.chapter09;

import java.util.List;

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

	@FindBy(css="#the-list .row-title")
	WebElement latestPost;

	@FindBy(css="#the-list tr")
	List<WebElement> postList;
	
	private final String pageUrl = Utils.getProperty("wordpressUrl") + "wp-admin/edit.php";

	
	public AdminAllPostsPage(WebDriver driver){
		this.driver = driver;
		driver.get(pageUrl);
	}
	
	/**
	 * 新しい投稿をする
	 * @param titleStr
	 * @param description
	 */
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
	
	/**
	 * 最新の投稿を削除する
	 */
	public void deleteLatestPost(){
		// 削除対象の投稿編集画面に移動
		latestPost.click();
		// 投稿をゴミ箱に移動
		WebElement deleteButton = driver.findElement(By.cssSelector("#delete-action>.submitdelete"));
		deleteButton.click();
	}

	
	public void deletePost(String title){
		
	}
	
	public void filterPostsByCategory(String category){
		
	}
	
	public void searchInPosts(String searchText){
		
	}

	public int getAllPostsCount(){
		return postList.size();
	}

}
