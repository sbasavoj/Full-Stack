package com.cg.ioexception.streambuffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
public static void byteReadWriteWork(File fromFile,File toFile) throws IOException{
	try(BufferedInputStream src=new BufferedInputStream(new FileInputStream(fromFile))){
		try(BufferedOutputStream dest=new BufferedOutputStream(new FileOutputStream(toFile))){
			/*int a=src.read();
			while(a!=-1){
				dest.write((char)a);
			}*/
			byte[] dataBuffer=new byte[(int)fromFile.length()];
			src.read(dataBuffer);
			dest.write(dataBuffer);
		}
	}
	
	/*FileInputStream src=new FileInputStream(fromFile);
	FileOutputStream dest=new FileOutputStream(toFile);
	int a=src.read();
	while(a!=-1){
		dest.write((char)a);
	}
	byte[] dataBuffer=new byte[(int)fromFile.length()];
	src.read(dataBuffer);
	dest.write(dataBuffer);*/
}
}
