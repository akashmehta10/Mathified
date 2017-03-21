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
public class Delmit {
 
	@RequestMapping("/delimit")
	public ModelAndView delimit() {
		return new ModelAndView("delimit");
	}
}
