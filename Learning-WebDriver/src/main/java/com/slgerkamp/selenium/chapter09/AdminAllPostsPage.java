package com.slgerkamp.selenium.chapter09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	public void createNewPost(String title, String description){
		driver.findElement(By.linkText("新規追加")).click();
		AdminNewPostPage adminNewPostPage = PageFactory.initElements(driver, AdminNewPostPage.class);
		adminNewPostPage.addNewPost(title, description);
	}

	public void editPost(String presentTitle, String newTitle, String newDescription){
		List<WebElement> allPosts = postsContainer.findElements(By.className("row-title"));
		for(WebElement element : allPosts){
			if(element.getText().equals(presentTitle)){
				Actions builder = new Actions(driver);
				builder.moveToElement(element);
				builder.click(driver.findElement(By.cssSelector(".edit>a")));
				builder.perform();
				break;
			}
		}
		// 本来は編集画面を作成したほうが良いが、
		// 作成ページで代用ができてしまったので、今回は省略
		AdminNewPostPage editPage = PageFactory.initElements(driver, AdminNewPostPage.class);
		editPage.addNewPost(newTitle, newDescription);
		
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
