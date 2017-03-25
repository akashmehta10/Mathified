package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class Delmit {
 
	@RequestMapping("/delimit")
	public ModelAndView delimit() {
		return new ModelAndView("delimit");
	}
}
