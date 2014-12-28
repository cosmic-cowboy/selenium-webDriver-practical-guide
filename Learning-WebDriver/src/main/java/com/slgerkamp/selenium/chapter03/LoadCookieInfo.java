package com.slgerkamp.selenium.chapter03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadCookieInfo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://twitter.com/");
		
		try {
			// クッキー情報保存用ファイル
			File cookieData = new File("browser.data");
			FileReader fileReader = new FileReader(cookieData);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;
			// ファイルに保存されたクッキー情報を取得し、
			while((line = reader.readLine()) != null){
				StringTokenizer str = new StringTokenizer(line, ";");
				while(str.hasMoreTokens()){
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					if(!(dt = str.nextToken()).equals("null")){
						expiry = new Date(dt);
					}
					boolean isSecure = new Boolean(str.nextToken()).booleanValue();
					Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.manage().addCookie(cookie);
				}
			}
			reader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		driver.get("https://twitter.com/");

	}
}
