package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinemathtool.helper.Helper;
import com.onlinemathtool.model.BasicOperationModel;

import org.json.*;
/*
 * author: Akash Mehta
 * 
 */
 
@Controller
public class Basic {
 
	@RequestMapping("/basic")
	public ModelAndView basic() {
		return new ModelAndView("basic");
	}
	
	@RequestMapping(value = "/basic/results", method = RequestMethod.POST)
	@ResponseBody
	public String getBasicResults(@RequestBody String numberList) {
		String numbers = Helper.getNumberListFromJson(numberList);
		if(numbers != null) {
			BasicOperationModel resultObj = new BasicOperationModel();
			resultObj.setResult(numbers);
			JSONObject jsonObjectResult = new JSONObject(resultObj);
			String jsonObjectResultString  =jsonObjectResult.toString();
			return jsonObjectResultString;
		}
		return null;
	}
}
