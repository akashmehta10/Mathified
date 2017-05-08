package com.onlinemathtool.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.onlinemathtool.helper.Helper;
import com.onlinemathtool.model.GridModel;
 
@Controller
public class Grid {
 
	@RequestMapping("/grid")
	public ModelAndView grid() {
		return new ModelAndView("grid");
	}
	
	@RequestMapping(value = "/grid/data", method = RequestMethod.POST)
	@ResponseBody
	public String getGridResults(@RequestBody String gridData, String selectedColumn, String groupBySumColumn) {
		if(gridData !=null && selectedColumn != null) {
			GridModel gridModelObj = new GridModel();
			if(groupBySumColumn == null || groupBySumColumn.isEmpty() || groupBySumColumn.equals("undefined")) {
				gridModelObj.setGroupByCountGridModelList(Helper.getGroupByRawHashMap(gridData, selectedColumn));
			}
			else {
				gridModelObj.setGroupBySumGridModelList(Helper.getGroupByRawHashMap(gridData, selectedColumn), groupBySumColumn);
			}
			JSONObject jsonObject = Helper.getGroupByJsonArrayResult(gridModelObj.getGroupByGridModelList(),selectedColumn, groupBySumColumn);
			return jsonObject.toString();
		}
		return null;
	}
}
