package com.utils;

import java.util.Random;

public class TestUtils {

	public static String getRandom() {
		
		Random r=new Random();
		
		int rnum=r.nextInt(10000);
		
		String Rnum=Integer.toString(rnum);
		return Rnum;
	}
	
	
}
