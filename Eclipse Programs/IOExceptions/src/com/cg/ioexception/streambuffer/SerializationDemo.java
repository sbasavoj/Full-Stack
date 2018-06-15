package com.cg.ioexception.streambuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.cg.ioexception.beans.Associate;
public class SerializationDemo {
	public static void doSerializtion(File file) throws FileNotFoundException, IOException{
		try(ObjectOutputStream src=new ObjectOutputStream(new FileOutputStream(file))){
			Associate associate=new Associate(123, 3000, "vidya", "basavoju");
			src.writeObject(associate);
		}

	}
	public static void doDeSerializtion(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream dest=new ObjectInputStream(new FileInputStream(file))){
			Associate associate=(Associate)dest.readObject();
			System.out.println(associate);
		}
	}
}
