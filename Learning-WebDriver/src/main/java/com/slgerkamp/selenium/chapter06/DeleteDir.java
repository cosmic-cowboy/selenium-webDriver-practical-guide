package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class DeleteDir {
	public static void main(String[] args) throws IOException {
		// ディレクトリを作成
		// まず com.slgerkamp.selenium.chapter06#CreateDir を実行
		FileHandler.delete(new File("Assets/chapter06/newDirectory"));
	}
}
