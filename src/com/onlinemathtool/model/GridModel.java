package com.onlinemathtool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class GridModel {
	private String columnValue;
	private Integer groupByValue;
	private List<GridModel> groupByGridModelList;
	private static final Logger logger = Logger.getLogger(GridModel.class);
	
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
			logger.info("Grouping by grid data from hashmap");
			groupByGridModelList = new ArrayList<GridModel>();
			for(String key: groupByRawGridData.keySet()) {
				GridModel gridModelObj = new GridModel();
				gridModelObj.setColumnValue(key);
				gridModelObj.setGroupByValue(groupByRawGridData.get(key).size());
				groupByGridModelList.add(gridModelObj);
			}
			logger.info("Grouped grid data from hashmap");
			logger.debug("List of GridModel object: " + groupByGridModelList);
		}
		catch(Exception exception) {
			groupByGridModelList = null;
			logger.error("Got exception grouping grid data from hashmap");
			logger.error(exception.getMessage());
		}
	}
	
	public void setGroupBySumGridModelList(Map<String, List<ArrayList<String>>> groupByRawGridData, String sumColumn) {
		try {
			logger.info("Grouping by and summing grid data from hashmap");
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
			logger.info("Grouped and summed grid data from hashmap");
			logger.debug("List of GridModel object: " + groupByGridModelList);
		}
		catch(Exception exception) {
			groupByGridModelList = null;
			logger.error("Got exception grouping and summing grid data from hashmap");
			logger.error(exception.getMessage());
		}
	}
	
	public List<GridModel> getGroupByGridModelList() {
		return groupByGridModelList;
	}
}