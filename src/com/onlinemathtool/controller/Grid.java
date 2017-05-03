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

import com.onlinemathtool.helper.Helper;
 
@Controller
public class Grid {
 
	@RequestMapping("/grid")
	public ModelAndView grid() {
		return new ModelAndView("grid");
	}
	
	@RequestMapping(value = "/grid/data", method = RequestMethod.POST)
	@ResponseBody
	public String getGridResults(@RequestBody String gridData, String selectedColumn) {
		return Helper.getGroupByResult(gridData, selectedColumn);
	}
}
