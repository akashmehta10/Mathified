package com.onlinemathtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/*
 * author: Akash Mehta
 * 
 */
 
@Controller
public class Home {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World!!!, Online Math Tool</h3>This message is coming from Home.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
