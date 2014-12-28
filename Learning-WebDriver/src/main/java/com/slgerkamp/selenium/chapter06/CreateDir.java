package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class CreateDir {
	public static void main(String[] args) throws IOException {
		// 新しいディレクトリを作成
		FileHandler.createDir(new File("Assets/chapter06/newDirectory"));
	}
}
