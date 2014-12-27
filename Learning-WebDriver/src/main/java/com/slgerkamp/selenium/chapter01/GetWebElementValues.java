package com.slgerkamp.selenium.chapter01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetWebElementValues {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		WebElement searchButton = driver.findElement(By.name("btnK"));

		// CSS value
		System.out.println("getCssValue");	
		System.out.println("font-family : " + searchButton.getCssValue("font-family"));	
		System.out.println("background-color : " + searchButton.getCssValue("background-color"));	
		System.out.println();

		// Location
		// Point型 座標
		System.out.println("getLocation : " + searchButton.getLocation());	
		System.out.println();

		// Size
		// 幅と高さ
		System.out.println("getSize : " + searchButton.getSize());	
		System.out.println();

		// Text
		// テキスト
		System.out.println("getText : " + searchButton.getText());	
		System.out.println();
		System.out.println("value : " + searchButton.getAttribute("value"));	
		System.out.println();
		// TagName
		// タグ
		System.out.println("getTagName : " + searchButton.getTagName());	
		System.out.println();

		// 表示されているか
		System.out.println("isDisplay : " + searchButton.isDisplayed());	
		System.out.println();

		// 有効化
		System.out.println("isEnabled : " + searchButton.isEnabled());	
		System.out.println();

		// 選択されているか
		// ラジオボタンやセレクトボックス、チェックボックスで使用
		// 選択されていない、もしくは選択可能な要素でない場合はfalse
		System.out.println("isSelected : " + searchButton.isSelected());	
		System.out.println();
	}
}
