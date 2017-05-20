package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinemathtool.helper.Helper;
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
		String[] compareLists = Helper.getListsFromJson(lists);
		if(compareLists != null) {
			CompareListsModel resultObj = new CompareListsModel();
			resultObj.setResult(compareLists[0], compareLists[1]);
			JSONObject jsonObjectResult = new JSONObject(resultObj);
			String jsonObjectResultString  =jsonObjectResult.toString();
			return jsonObjectResultString;
		}
		return null;
	}
}
