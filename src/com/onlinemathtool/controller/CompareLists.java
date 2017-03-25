package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.onlinemathtool.model.BasicOperationModel;
import org.json.*;

@Controller
public class CompareLists {
	@RequestMapping("/compare")
	public ModelAndView basic() {
		return new ModelAndView("compare");
	}
	
	@RequestMapping(value = "/compare/lists", method = RequestMethod.GET)
	@ResponseBody
	public String getBasicResults(String list1, String list2) {
		BasicOperationModel resultObj = new BasicOperationModel();
		//resultObj.setResult(numberList);
		JSONObject jsonObject = new JSONObject(resultObj);
		String myJson  =jsonObject.toString();
		return myJson;
	}
}
