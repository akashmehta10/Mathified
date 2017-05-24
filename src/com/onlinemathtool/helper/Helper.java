package com.onlinemathtool.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.onlinemathtool.model.GridModel;

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
	
	public static Map<String, List<ArrayList<String>>> getGroupByRawHashMap(String gridData, String selectedColumn) {
		try {
			JSONObject jsonObject = new JSONObject(gridData);
			JSONArray jsonArray = jsonObject.getJSONArray("gridData");
			System.out.println("Length: " + jsonArray.length());
			int selectedColumnVal = Integer.parseInt(selectedColumn) + 1;
			System.out.println("Selected Column: " + selectedColumnVal);
			Map<String, List<ArrayList<String>>> groupByGridData = new HashMap<String, List<ArrayList<String>>>();
			for(int i = 0 ; i < jsonArray.length(); i++) {
				JSONObject jsonRow = jsonArray.getJSONObject(i);
				if(jsonRow.has("col"+selectedColumnVal)) {
					String colVal = jsonRow.getString("col"+selectedColumnVal);
					ArrayList<String> sameRowEntries = new ArrayList<String>(10);	
					for(int j = 1; j < 10; j++) {
						if(jsonRow.has("col"+j)) {
							sameRowEntries.add(jsonRow.getString("col"+j));
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
			System.out.println(groupByGridData);
			return groupByGridData;
		}
		catch(Exception exception) {
			return null;
		}
	}
	
	public static JSONObject getGroupByJsonArrayResult(List<GridModel> gridModelList, String selectedColumn, String groupBySumColumn) {
		try {
			JSONObject resultJSONObject = new JSONObject();
			resultJSONObject.put("groupByOperation", groupBySumColumn == null || groupBySumColumn.isEmpty() || groupBySumColumn.equals("undefined") ? "Count" : "Sum");
			resultJSONObject.put("selectedColumn", Integer.parseInt(selectedColumn) + 1);
			JSONArray jsonArray = new JSONArray();
			for (GridModel gridObj : gridModelList) {
			    JSONObject obj = new JSONObject();
			    obj.put("key", gridObj.getColumnValue());
			    obj.put("value", gridObj.getGroupByValue());
			    jsonArray.put(obj);
			}
			System.out.println(jsonArray.toString());
			resultJSONObject.put("success", true);
			resultJSONObject.put("resultArray", jsonArray);
			return resultJSONObject;
		}
		catch(Exception exception) {
			return null;
		}
	}
	
	public static String[] getListsFromJson(String listsJson) {
		try {
			JSONObject jsonObject = new JSONObject(listsJson);
			String[] listArray = new String[2];
			if(jsonObject != null && jsonObject.has("lists")) {
				JSONObject jsonObjectLists = jsonObject.getJSONObject("lists");
				if(jsonObjectLists != null && jsonObjectLists.has("list1") && jsonObjectLists.has("list2")) {
					listArray[0] = jsonObjectLists.getString("list1");
					listArray[1] = jsonObjectLists.getString("list2");
					return listArray;
				}
			}
			return null;
		}
		catch(Exception exception) {
			return null;
		}
	}
	
	public static String getNumberListFromJson(String numberListJson) {
		try {
			JSONObject jsonObject = new JSONObject(numberListJson);
			String numberList;
			if(jsonObject != null && jsonObject.has("numberList")) {
				numberList = jsonObject.getString("numberList");
				return numberList;
			}
			return null;
		}
		catch(Exception exception) {
			return null;
		}
	}
	
	public static String[] getFeedbackFromJson(String feedback) {
		try {
			JSONObject jsonObject = new JSONObject(feedback);
			String[] listArray = new String[3];
			if(jsonObject != null && jsonObject.has("feedback")) {
				JSONObject jsonObjectLists = jsonObject.getJSONObject("feedback");
				if(jsonObjectLists != null && jsonObjectLists.has("name") && jsonObjectLists.has("email") && jsonObjectLists.has("feedbackText")) {
					listArray[0] = jsonObjectLists.getString("name");
					listArray[1] = jsonObjectLists.getString("email");
					listArray[2] = jsonObjectLists.getString("feedbackText");
					return listArray;
				}
			}
			return null;
		}
		catch(Exception exception) {
			return null;
		}
	}
}
