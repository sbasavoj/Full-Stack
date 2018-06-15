package com.cg.ioexception.main;

import java.io.File;
import java.io.IOException;

import com.cg.ioexception.streambuffer.ByteStreamDemo;

public class MainClass2 {

	public static void main(String[] args) {
		File fromFile=new File("D:\\vidya\\collectionsQuestions.txt");
		File toFile=new File("D:\\Users\\sbasavoj\\Downloads\\abc.txt");
		try {
			ByteStreamDemo.byteReadWriteWork(fromFile, toFile);
			if(!toFile.exists())
				toFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
