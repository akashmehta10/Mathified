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
							sameRowEntries.add(j - 1, jsonRow.getString("col"+j));
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
	
	public static List<GridModel> getGroupByCountResult(Map<String, List<ArrayList<String>>> groupByRawGridData) {
		try {
			List<GridModel> groupByGridModelList = new ArrayList<GridModel>();
			for(String key: groupByRawGridData.keySet()) {
				GridModel gridModelObj = new GridModel();
				gridModelObj.setColumnValue(key);
				gridModelObj.setGroupByValue(groupByRawGridData.get(key).size());
				groupByGridModelList.add(gridModelObj);
			}
			return groupByGridModelList;
		}
		catch(Exception exception) {
			return null;
		}
	}
}
