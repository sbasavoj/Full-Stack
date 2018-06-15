package com.cg.ioexception.main;
import java.io.File;
import java.io.IOException;

import com.cg.ioexception.streambuffer.SerializationDemo;
public class MainClass {
	public static void main(String[] args) {
		File file=new File("d://vidya//asd.txt");
		try {
			if(!file.exists())
				file.createNewFile();
			SerializationDemo.doSerializtion(file);
			SerializationDemo.doDeSerializtion(file);
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("Input output Exception");
			e.printStackTrace();
		}
	}
}


