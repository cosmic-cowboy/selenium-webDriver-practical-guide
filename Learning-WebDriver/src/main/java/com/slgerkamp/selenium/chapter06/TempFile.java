package com.slgerkamp.selenium.chapter06;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;

public class TempFile {
	public static void main(String[] args) throws InterruptedException {
		
		// 一時ファイルシステムの変更
		TemporaryFilesystem tmpFS = TemporaryFilesystem.getTmpFsBasedOn(new File("Assets/chapter06/tmp"));
		// 一時ファイルディレクトリを取得、作成
//		File tempDir = TemporaryFilesystem.getDefaultTmpFS().createTempDir("prefix", "suffix");
		File tempDir = tmpFS.createTempDir("prefix", "suffix");
		System.out.println(tempDir.getAbsolutePath());
		Thread.sleep(30000);
		// 一時ファイルディレクトリを取得、作成
//		TemporaryFilesystem.getDefaultTmpFS().deleteTempDir(tempDir);
		tmpFS.deleteTempDir(tempDir);
		Thread.sleep(30000);
	}
}
