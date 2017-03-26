package com.onlinemathtool.helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public static List<String> getStringList(String list) {
		try {
			List<String> listString = Arrays.asList(list.split(","));
			return listString;
		}
		catch(Exception exception) {
			return null;
		}
	}
	
	public static Set<String> getSetFromList(List<String> stringList) {
		return new HashSet<>(stringList);
	}
}
