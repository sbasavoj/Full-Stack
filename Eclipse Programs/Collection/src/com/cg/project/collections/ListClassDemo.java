package com.cg.project.collections;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

//import java.util.Iterator;
import com.cg.project.beans.Associate;
import com.cg.project.beans.CompareClass;
public class ListClassDemo {
	
	public static void main(String[] args) {
		LinkedList<Associate> assList=new LinkedList<>();
		assList.add(new Associate(111, "Vidya", "Basavoju"));
		assList.add(new Associate(112, "Lekha", "Basavoju"));
		assList.add(new Associate(231, "LOWKYA", "Basavoju"));
		assList.add(new Associate(451, "lowkya", "Basavoju"));
		assList.add(new Associate(191, "Lowkya", "Basavoju"));
		Collections.sort(assList);
		for (Associate associate : assList) {
			System.out.println(associate);
		}
		System.out.println("**************************************************");
		Collections.sort(assList,new CompareClass());
		for (Associate associate : assList) {
			System.out.println(associate);
		} 
	}
}

