package com.onlinemathtool.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.onlinemathtool.model.GridModel;

public class Helper {
	private static final Logger logger = Logger.getLogger(Helper.class);

	public static float[] getNumberArray(String listOfNumbers) {
		try {
			logger.info("Processing comma separated number list to array of numbers");
			logger.debug("Number list: " + listOfNumbers);
			String []stringArray = listOfNumbers.split(",");
			float []numberArray = new float[stringArray.length];
			int counter = 0;
			for(String s: stringArray) {
				numberArray[counter++] = Float.parseFloat(s);
			}
			logger.info("Processed comma separated number list to array of numbers");
			logger.debug("Number Array: " + numberArray);
			return numberArray;
		}
		catch(Exception exception) {
			logger.error("Got exception when processing comma separated number list to array of numbers");
			logger.error(exception.getMessage());
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
	
	public static Map<String, List<ArrayList<String>>> getGroupByRawHashMap(String gridData, String selectedColumn) {
		try {
			logger.info("Processing grid data to hashmap");
			logger.debug("Grid data: " + gridData);
			logger.debug("Selected column: " + selectedColumn);
			JSONObject jsonObject = new JSONObject(gridData);
			JSONArray jsonArray = jsonObject.getJSONArray("gridData");
			int selectedColumnVal = Integer.parseInt(selectedColumn) + 1;
			Map<String, List<ArrayList<String>>> groupByGridData = new HashMap<String, List<ArrayList<String>>>();
			for(int i = 0 ; i < jsonArray.length(); i++) {
				JSONObject jsonRow = jsonArray.getJSONObject(i);
				logger.debug("Json row: "+ i + ", Value: "+ jsonRow);
				if(jsonRow.has("col"+selectedColumnVal)) {
					String colVal = jsonRow.getString("col"+selectedColumnVal);
					ArrayList<String> sameRowEntries = new ArrayList<String>(10);	
					for(int j = 1; j < 10; j++) {
						if(jsonRow.has("col"+j)) {
							sameRowEntries.add(jsonRow.getString("col"+j));
						}
						else {
							sameRowEntries.add("");
						}
					}	
					if(!groupByGridData.containsKey(colVal)) {
						List<ArrayList<String>> newKeyLists = new ArrayList<ArrayList<String>>();
						newKeyLists.add(sameRowEntries);
						groupByGridData.put(colVal, newKeyLists);
					}
					else {
						List<ArrayList<String>> sameKeyLists = groupByGridData.get(colVal);
						sameKeyLists.add(sameRowEntries);
						groupByGridData.put(colVal, sameKeyLists);
					}
				}
			}
			logger.info("End processing grid data to hashmap");
			logger.debug("Hashmap data"+ groupByGridData);
			return groupByGridData;
		}
		catch(Exception exception) {
			logger.error("Got exception when processing grid data to hashmap");
			logger.error(exception.getMessage());
			return null;
		}
	}
	
	public static JSONObject getGroupByJsonArrayResult(List<GridModel> gridModelList, String selectedColumn, String groupBySumColumn) {
		try {
			logger.info("Processing List of GridModel object");
			logger.debug("Lists of GridModel: " + gridModelList);
			logger.debug("Selected column: " + selectedColumn);
			logger.debug("Group by sum Column: " + groupBySumColumn);
			JSONObject resultJSONObject = new JSONObject();
			resultJSONObject.put("groupByOperation", groupBySumColumn == null || groupBySumColumn.isEmpty() || groupBySumColumn.equals("undefined") ? "Count" : "Sum");
			resultJSONObject.put("selectedColumn", Integer.parseInt(selectedColumn) + 1);
			JSONArray jsonArray = new JSONArray();
			logger.info("Populating Json Array with keys and values of grid data");
			for (GridModel gridObj : gridModelList) {
			    JSONObject obj = new JSONObject();
			    obj.put("key", gridObj.getColumnValue());
			    obj.put("value", gridObj.getGroupByValue());
			    jsonArray.put(obj);
			}
			logger.info("Json Array populated");
			resultJSONObject.put("success", true);
			resultJSONObject.put("resultArray", jsonArray);
			logger.info("Result Json object created");
			logger.debug("Result Json object" + resultJSONObject);
			return resultJSONObject;
		}
		catch(Exception exception) {
			logger.error("Got exception when processing grid data to JSON object");
			logger.error(exception.getMessage());
			return null;
		}
	}
	
	public static String[] getListsFromJson(String listsJson) {
		try {
			logger.info("Processing compare lists JSON");
			logger.debug("Lists Input: " + listsJson);
			JSONObject jsonObject = new JSONObject(listsJson);
			logger.info("Converted lists JSON to JSON object");
			String[] listArray = new String[2];
			if(jsonObject != null && jsonObject.has("lists")) {
				JSONObject jsonObjectLists = jsonObject.getJSONObject("lists");
				if(jsonObjectLists != null && jsonObjectLists.has("list1") && jsonObjectLists.has("list2")) {
					listArray[0] = jsonObjectLists.getString("list1");
					listArray[1] = jsonObjectLists.getString("list2");
					logger.info("Converted JSON string to string array: list1 and list2");
					return listArray;
				}
			}
			return null;
		}
		catch(Exception exception) {
			logger.error("Got exception when converting lists JSON string to string array");
			logger.error(exception.getMessage());
			return null;
		}
	}
	
	public static String getNumberListFromJson(String numberListJson) {
		try {
			logger.info("Processing number list JSON");
			logger.debug("Number Input: " + numberListJson);
			JSONObject jsonObject = new JSONObject(numberListJson);
			logger.info("Converted number list JSON to JSON object");
			String numberList;
			if(jsonObject != null && jsonObject.has("numberList")) {
				numberList = jsonObject.getString("numberList");
				logger.info("Converted JSON string to comma separated string");
				return numberList;
			}
			return null;
		}
		catch(Exception exception) {
			logger.error("Got exception when converting number JSON string to comma separated string");
			logger.error(exception.getMessage());
			return null;
		}
	}
	
	public static String[] getFeedbackFromJson(String feedback) {
		try {
			logger.info("Processing feedback JSON");
			logger.debug("Feedback Input: " + feedback);
			JSONObject jsonObject = new JSONObject(feedback);
			logger.info("Converted feedback JSON to JSON object");
			String[] listArray = new String[3];
			if(jsonObject != null && jsonObject.has("feedback")) {
				JSONObject jsonObjectLists = jsonObject.getJSONObject("feedback");
				if(jsonObjectLists != null && jsonObjectLists.has("name") && jsonObjectLists.has("email") && jsonObjectLists.has("feedbackText")) {
					listArray[0] = jsonObjectLists.getString("name");
					listArray[1] = jsonObjectLists.getString("email");
					listArray[2] = jsonObjectLists.getString("feedbackText");
					logger.info("Converted JSON string to string array: name, email and feedback");
					return listArray;
				}
			}
			return null;
		}
		catch(Exception exception) {
			logger.error("Got exception when converting feedback JSON string to string array");
			logger.error(exception.getMessage());
			return null;
		}
	}
}
