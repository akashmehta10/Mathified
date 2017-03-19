package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
		String message = "Coming from Home";
		return new ModelAndView("basic", "message", message);
	}
	
	@RequestMapping(value = "/basic/results", method = RequestMethod.GET)
	@ResponseBody
	public String getBasicResults(String numberList) {
		BasicOperationModel resultObj = new BasicOperationModel();
		float [] numberArray = resultObj.getNumberArray(numberList);
		resultObj.setResult(numberArray);
		JSONObject jsonObject = new JSONObject(resultObj);
		String myJson  =jsonObject.toString();
		return myJson;
	}
}
