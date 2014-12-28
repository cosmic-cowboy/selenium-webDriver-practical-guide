package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class FileController {
	
	public static void main(String[] args) throws IOException {
		
		// zipファイル
		System.out.println("ZIPファイルか：" + FileHandler.isZipped("Assets/chapter06/src/src_file.zip"));

		File src_file = new File("Assets/chapter06/src/src_file.txt");
		// 読み込み
		System.out.println("読み込み内容：" + FileHandler.readAsString(src_file));
		
		// 書き込み可能か、実行可能なファイルか、実行可能なファイルに
		System.out.println("書き込み可能なファイルに：" + FileHandler.makeWritable(src_file));
		System.out.println("実行可能なファイルか：" + FileHandler.canExecute(src_file));
		System.out.println("実行可能なファイルに：" + FileHandler.makeExecutable(src_file));
		System.out.println("実行可能なファイルか：" + FileHandler.canExecute(src_file));
		
	}
}
