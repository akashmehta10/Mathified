package com.onlinemathtool.model;

import com.onlinemathtool.helper.Helper;

public class BasicOperationModel {
	private String numberList;
	private float sum;
	private float average;
	private float sd;
	private float variance;
	private int count;
	private Boolean success;
	
	public void setNumberList(String _numberList) {
		numberList = _numberList;
	}
	
	public String getNumberList() {
		return numberList;
	}
	
	public void setResult(String listOfNumbers) {
		float [] numberArray = Helper.getNumberArray(listOfNumbers);
		if(numberArray == null) {
			success = false;
			return;
		}
		setSum(numberArray);
		setCount(numberArray);
		setAverage(sum, count);
		setVariance(numberArray, average, count);
		setSd(variance);
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
	
	public float getVariance() {
		return variance;
	}
	
	public float getSd() {
		return sd;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setSum(float[] numberArray) {
		float sumNumbers = 0f;
		for(float number: numberArray) {
			sumNumbers += number;
		}
		sum = sumNumbers;
	}
	
	public void setCount(float[] numberArray) {
		count = numberArray.length;
	}
	
	public void setAverage(float _sum, int _count) {
		average = _sum/_count;
	}
	
	public void setVariance(float[] numberArray, float _average, int _count) {
		float sumSquareDifference = 0f;
		for(float number:numberArray) {
			sumSquareDifference += Math.pow((number - _average) , 2);
		}
		variance = sumSquareDifference/_count;
	}
	
	public void setSd(float _variance) {
		sd = (float) Math.sqrt(_variance);
	}
 }


