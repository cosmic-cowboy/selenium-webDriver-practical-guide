package com.slgerkamp.selenium.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	
	private static Properties props;
	
	public static String getProperty(String key){
		if(props == null){
			props = new Properties();
			try {
				FileInputStream fis = new FileInputStream(new File("Assets/selenium.properties"));
				props.load(fis);
				fis.close();		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String)props.get(key);
		
	}
}
