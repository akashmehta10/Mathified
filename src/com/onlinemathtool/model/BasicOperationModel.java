package com.onlinemathtool.model;

import org.apache.log4j.Logger;

import com.onlinemathtool.helper.Helper;

public class BasicOperationModel {
	private String numberList;
	private float sum;
	private float average;
	private float sd;
	private float variance;
	private int count;
	private Boolean success;
	
	private static final Logger logger = Logger.getLogger(BasicOperationModel.class);
	
	public void setNumberList(String _numberList) {
		numberList = _numberList;
	}
	
	public String getNumberList() {
		return numberList;
	}
	
	public void setResult(String listOfNumbers) {
		logger.info("Setting result on list of numbers");
		float [] numberArray = Helper.getNumberArray(listOfNumbers);
		if(numberArray == null) {
			success = false;
			logger.error("Got number array as null returning control");
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
		logger.info("Setting sum on list of numbers");
		float sumNumbers = 0f;
		for(float number: numberArray) {
			sumNumbers += number;
		}
		sum = sumNumbers;
		logger.info("Sum: " + sum);
	}
	
	public void setCount(float[] numberArray) {
		logger.info("Setting count on list of numbers");
		count = numberArray.length;
		logger.info("Count: " + count);
	}
	
	public void setAverage(float _sum, int _count) {
		logger.info("Setting average on list of numbers");
		average = _sum/_count;
		logger.info("Average: " + average);
	}
	
	public void setVariance(float[] numberArray, float _average, int _count) {
		logger.info("Setting average on list of numbers");
		float sumSquareDifference = 0f;
		for(float number:numberArray) {
			sumSquareDifference += Math.pow((number - _average) , 2);
		}
		variance = sumSquareDifference/_count;
		logger.info("Variance: " + variance);
	}
	
	public void setSd(float _variance) {
		logger.info("Setting SD on list of numbers");
		sd = (float) Math.sqrt(_variance);
		logger.info("SD: " + sd);
	}
 }


