package com.slgerkamp.selenium.chapter03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StoreCookieInfo {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// twitterにログイン
		driver.get("https://twitter.com/");
		// ID
		WebElement signinEmail = driver.findElement(By.id("signin-email"));
		signinEmail.sendKeys("id");
		// PASS
		WebElement signinPassword = driver.findElement(By.id("signin-password"));
		signinPassword.sendKeys("pass");
		// Login
		WebElement signin = driver.findElement(By.className("js-submit"));
		signin.click();
		
		
		try {
			// クッキー情報保存用ファイル
			File cookieData = new File("browser.data");
			cookieData.delete();
			cookieData.createNewFile();
			FileWriter fileWriter = new FileWriter(cookieData);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// クッキー情報を取得し、ファイルに保存
			for(Cookie cookie : driver.manage().getCookies()){
				writer.write(cookie.getName() + ";" 
						+ cookie.getValue() + ";" 
						+ cookie.getDomain() + ";" 
						+ cookie.getPath() + ";" 
						+ cookie.getExpiry() + ";" 
						+ cookie.isSecure() + ";" 
						);
				writer.newLine();
			}
			writer.flush();
			writer.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
