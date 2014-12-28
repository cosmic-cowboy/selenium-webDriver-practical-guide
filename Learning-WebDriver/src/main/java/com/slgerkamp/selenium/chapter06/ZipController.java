package com.slgerkamp.selenium.chapter06;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.Zip;

public class ZipController {
	public static void main(String[] args) throws IOException {
		File inputFile  = new File("Assets/chapter06/src");
		File outputFIle = new File("Assets/chapter06/src/src.zip");
		File unzipFile  = new File("Assets/chapter06/tmp");
		Zip zip = new Zip();
		// zip化
		zip.zip(inputFile, outputFIle);
		// unzip化
		zip.unzip(outputFIle, unzipFile);

	}
}
