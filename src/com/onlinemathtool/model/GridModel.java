package com.onlinemathtool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GridModel {
	private String columnValue;
	private Integer groupByValue;
	private List<GridModel> groupByGridModelList;
	
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
	
	public void setGroupByCountGridModelList(Map<String, List<ArrayList<String>>> groupByRawGridData) {
		try {
			groupByGridModelList = new ArrayList<GridModel>();
			for(String key: groupByRawGridData.keySet()) {
				GridModel gridModelObj = new GridModel();
				gridModelObj.setColumnValue(key);
				gridModelObj.setGroupByValue(groupByRawGridData.get(key).size());
				groupByGridModelList.add(gridModelObj);
			}
		}
		catch(Exception exception) {
			groupByGridModelList = null;
		}
	}
	
	public void setGroupBySumGridModelList(Map<String, List<ArrayList<String>>> groupByRawGridData, String sumColumn) {
		try {
			groupByGridModelList = new ArrayList<GridModel>();
			for(String key: groupByRawGridData.keySet()) {
				GridModel gridModelObj = new GridModel();
				int sum = 0;
				gridModelObj.setColumnValue(key);
				List<ArrayList<String>> groupByValueList = groupByRawGridData.get(key);
				for(ArrayList<String> list : groupByValueList) {
					sum += Integer.parseInt(list.get(Integer.parseInt(sumColumn) - 1));
				}
				gridModelObj.setGroupByValue(sum);
				groupByGridModelList.add(gridModelObj);
			}
		}
		catch(Exception exception) {
			groupByGridModelList = null;
		}
	}
	
	public List<GridModel> getGroupByGridModelList() {
		return groupByGridModelList;
	}
}