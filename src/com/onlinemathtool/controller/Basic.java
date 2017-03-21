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
		return new ModelAndView("basic");
	}
	
	@RequestMapping(value = "/basic/results", method = RequestMethod.GET)
	@ResponseBody
	public String getBasicResults(String numberList) {
		BasicOperationModel resultObj = new BasicOperationModel();
		resultObj.setResult(numberList);
		JSONObject jsonObject = new JSONObject(resultObj);
		String myJson  =jsonObject.toString();
		return myJson;
	}
}
