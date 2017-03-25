package com.onlinemathtool.helper;

public class Helper {
	public static float[] getNumberArray(String listOfNumbers) {
		try {
			String []stringArray = listOfNumbers.split(",");
			float []numberArray = new float[stringArray.length];
			int counter = 0;
			for(String s: stringArray) {
				numberArray[counter++] = Float.parseFloat(s);
			}
			return numberArray;
		}
		catch(Exception exception) {
			return null;
		}
	}

	public static String[] getStringArray(String list) {
		try {
			String []stringArray = list.split(",");
			return stringArray;
		}
		catch(Exception exception) {
			return null;
		}
	}	
}
