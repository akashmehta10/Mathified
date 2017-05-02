package com.onlinemathtool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class Grid {
 
	@RequestMapping("/grid")
	public ModelAndView grid() {
		return new ModelAndView("grid");
	}
	
	@RequestMapping(value = "/grid/data", method = RequestMethod.POST)
	@ResponseBody
	public String getGridResults(@RequestBody String gridData, String selectedColumn) {
		JSONObject jsonObject = new JSONObject(gridData);
		JSONArray jsonArray = jsonObject.getJSONArray("gridData");
		System.out.println("Length: " + jsonArray.length());
		int selectedColumnVal = Integer.parseInt(selectedColumn) + 1;
		System.out.println("Selected Column: " + selectedColumnVal);
		Map<String, Integer> groupByGridData = new HashMap<String, Integer>();
		for(int i = 0 ; i < jsonArray.length(); i++) {
			//System.out.println("Row " + i + ":");
			JSONObject jsonRow = jsonArray.getJSONObject(i);
			if(jsonRow.has("col"+selectedColumnVal)) {
				String colVal = jsonRow.getString("col"+selectedColumnVal);
				if(!groupByGridData.containsKey(colVal)) {
					groupByGridData.put(colVal, 1);
				}
				else {
					int rowCount = groupByGridData.get(colVal) + 1;
					groupByGridData.put(colVal, rowCount);
				}
			}
			
//			for(int j =1 ; j <= 3 ; j++) {
//				if(jsonRow.has("col"+j)) {
//					String colVal = jsonRow.getString("col"+j);
//					System.out.print(" " + colVal);
//				}
//			}
			//System.out.println();
		}
		System.out.println(groupByGridData);
		return null;
	}
}
