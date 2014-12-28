package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class CopyDir {
	public static void main(String[] args) throws IOException {
		// ディレクトリごとコピー
		FileHandler.copy(new File("Assets/chapter06/src"), new File("Assets/chapter06/dest"));

		// ファイルだけ	
		FileHandler.copy(new File("Assets/chapter06/file/file.txt"), new File("Assets/chapter06/dest/file.txt"));
	}
}
