package com.onlinemathtool.model;

public class BasicOperationModel {
	private String numberList;
	private float sum;
	private float average;
	private float product;
	private int count;
	private String resultData;
	private Boolean success;
	
	public void setNumberList(String _numberList) {
		numberList = _numberList;
	}
	
	public String getNumberList() {
		return numberList;
	}
	
	public float[] getNumberArray(String listOfNumbers) {
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
	
	public void setResult(float[] numberArray) {
		if(numberArray == null) {
			success = false;
			return;
		}
		float sumNumbers = 0f;
		for(float number: numberArray) {
			sumNumbers += number;
		}
		sum = sumNumbers;
		count = numberArray.length;
		average = sumNumbers/count;
		resultData = "Count: " + count + ", Sum: " + sum + ", Average: " + average;
		success = true;
	}
	
	public float getSum() {
		return sum;
	}

	public float getCount() {
		return count;
	}
	
	public float getAverage() {
		return average;
	}
	
	public String getResultData() {
		return resultData;
	}
	
	public Boolean getSuccess() {
		return success;
	}
 }


