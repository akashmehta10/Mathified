package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.onlinemathtool.model.CompareListsModel;

import org.json.*;

@Controller
public class CompareLists {
	@RequestMapping("/compare")
	public ModelAndView basic() {
		return new ModelAndView("compare");
	}
	
	@RequestMapping(value = "/compare/lists", method = RequestMethod.POST)
	@ResponseBody
	public String getBasicResults(@RequestBody String lists) {
		JSONObject jsonObject = new JSONObject(lists);
		if(jsonObject != null && jsonObject.has("lists")) {
			JSONObject jsonObjectLists = jsonObject.getJSONObject("lists");
			if(jsonObjectLists != null && jsonObjectLists.has("list1") && jsonObjectLists.has("list2")) {
				CompareListsModel resultObj = new CompareListsModel();
				resultObj.setResult(jsonObjectLists.getString("list1"), jsonObjectLists.getString("list2"));
				JSONObject jsonObjectResult = new JSONObject(resultObj);
				String jsonObjectResultString  =jsonObjectResult.toString();
				return jsonObjectResultString;
			}
		}
		return null;
	}
}
