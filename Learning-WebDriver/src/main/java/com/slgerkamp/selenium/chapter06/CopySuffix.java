package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class CopySuffix {
	public static void main(String[] args) throws IOException {
		// 指定したサフィックスを持つファイルをコピー
		FileHandler.copy(new File("Assets/chapter06/src"), new File("Assets/chapter06/dest"), ".xml");
	}
}
