package com.slgerkamp.selenium.chapter07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.slgerkamp.selenium.lib.Utils;

public class TestScriptUserClientLibrary {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;
		String searchBox    = null;
		String searchButton = null;
		HttpPost postMethod = null;
		HttpGet  getMehod   = null;
		HttpDelete deleteMethod = null;
		String domain = "http://" + Utils.getProperty("remoteWebDriverUrl");
		
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setBrowserName("firefox");
//		RemoteWebDriver remoteWebDriver = 
//				new RemoteWebDriver(
//						new URL(), desiredCapabilities
//				);
		
		/////////////////////
		// セッションの生成
		/////////////////////
		postMethod = new HttpPost(domain + "/wd/hub/session");
		StringEntity input = null;
		JsonObject jo = new JsonObject();
		jo.addProperty("browserName", "firefox");
		JsonObject caps = new JsonObject();
		caps.add("desiredCapabilities", jo);
		System.out.println(caps.toString());
		
		input = new StringEntity(caps.toString());
		input.setContentEncoding("UTF-8");
		input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		postMethod.setEntity(input);	
		// postメソッドを設定
		response = httpClient.execute(postMethod);
		System.out.println(response.getEntity());

		/////////////////////
		// セッションの取得
		/////////////////////
		httpClient = new DefaultHttpClient();
		getMehod = new HttpGet(domain + "/wd/hub/sessions");
		response = httpClient.execute(getMehod);
		BufferedReader streamReader = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
		StringBuilder responseStrBuilder = new StringBuilder();
		String inputStr;
	    while ((inputStr = streamReader.readLine()) != null)
	        responseStrBuilder.append(inputStr);
	    JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject)parser.parse(responseStrBuilder.toString());
		System.out.println(json.toString());
		String sessionId = json.get("value").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
		System.out.println("sessionId : " + sessionId);
		streamReader.close();

		/////////////////////
		// Google検索ページに移動		
		// remoteWebDriver.get("http://www.google.com");
		/////////////////////
		httpClient = new DefaultHttpClient();
		postMethod = new HttpPost(domain + "/wd/hub/session/" + sessionId + "/url");
		JsonObject toGoogle = new JsonObject();
		toGoogle.addProperty("url", "http://google.com");
		input  = new StringEntity(toGoogle.toString());
		input.setContentEncoding("UTF-8");
		input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		postMethod.setEntity(input);
		response = httpClient.execute(postMethod);

		/////////////////////
		// Google検索ページに移動
		// WebElement searchBox = remoteWebDriver.findElement(By.name("q"));
		/////////////////////
		// HTTPクライアント作成
		httpClient = new DefaultHttpClient();
		// HTTP POSTメソッドの作成
		postMethod = new HttpPost(domain + "/wd/hub/session/" + sessionId + "/element");
		// POSTするJSONデータ作成
		JsonObject element = new JsonObject();
		element.addProperty("using", "name");
		element.addProperty("value", "q");
		input  = new StringEntity(element.toString());
		input.setContentEncoding("UTF-8");
		input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		// POSTデータの登録
		postMethod.setEntity(input);
		// リクエストの発行
		response = httpClient.execute(postMethod);
		BufferedReader elementStreamReader = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
		StringBuilder elementResponseStrBuilder = new StringBuilder();
		String elementInputStr;
	    while ((elementInputStr = elementStreamReader.readLine()) != null)
	    	elementResponseStrBuilder.append(elementInputStr);
	    JsonParser elementParser = new JsonParser();
		JsonObject elementJson = (JsonObject)elementParser.parse(elementResponseStrBuilder.toString());
		System.out.println(elementJson.toString());
		String searchBoxId = elementJson.get("value").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();

		/////////////////////
		// Google検索ページに移動
		// searchBox.sendKeys("selenium");
		/////////////////////
		// HTTPクライアントの作成
		httpClient = new DefaultHttpClient();
		// POSTメソッド作成
		postMethod = new HttpPost(domain + "/wd/hub/session/" + sessionId + "/element/" + searchBoxId + "/click");
		// リクエストの送信
		response = httpClient.execute(postMethod);
		
		// HTTPクライアントの作成
		httpClient = new DefaultHttpClient();
		// POSTメソッド作成
		postMethod = new HttpPost(domain + "/wd/hub/session/" + sessionId + "/element/" + searchBoxId + "/value");
		// POSTするJSONデータ作成
		element = new JsonObject();
		element.addProperty("value", "selenium");
		input  = new StringEntity(toGoogle.toString());
		input.setContentEncoding("UTF-8");
		input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		// POSTデータの登録
		postMethod.setEntity(input);
		// リクエストの送信
		response = httpClient.execute(postMethod);
		
		/////////////////////
		// セッション終了
		// remoteWebDriver.quit();
		/////////////////////
		httpClient = new DefaultHttpClient();
		deleteMethod = new HttpDelete(domain + "/wd/hub/session/" + sessionId);
		response = httpClient.execute(deleteMethod);
	}
}
