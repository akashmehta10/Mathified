package com.onlinemathtool.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinemathtool.model.CompareListsModel;
 
@Controller
public class Grid {
 
	@RequestMapping("/grid")
	public ModelAndView grid() {
		return new ModelAndView("grid");
	}
	
	@RequestMapping(value = "/grid/data", method = RequestMethod.GET)
	@ResponseBody
	public String getGridResults(String gridData) {
		return "Response from Grid Controller";
	}
}
