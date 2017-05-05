package com.onlinemathtool.model;

public class GridModel {
	private String columnValue;
	private Integer groupByValue;
	
	public void setColumnValue(String _columnValue) {
		columnValue = _columnValue;
	}
	
	public String getColumnValue() {
		return columnValue;
	}
	
	public void setGroupByValue(Integer _groupByValue) {
		groupByValue = _groupByValue;
	}
	
	public Integer getGroupByValue() {
		return groupByValue;
	}
}