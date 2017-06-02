package com.onlinemathtool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinemathtool.helper.Helper;
import com.onlinemathtool.model.FeedbackModel;

@Controller
public class Feedback {
	@Value("${env.filelocation}")
	private String fileLocation;
	
	@RequestMapping("/feedback")
	public ModelAndView feedback() {
		return new ModelAndView("feedback");
	}

	@RequestMapping(value = "/feedback/submit", method = RequestMethod.POST)
	@ResponseBody
	public String submitFeedback(@RequestBody String feedback) {
		String[] feedbackArray = Helper.getFeedbackFromJson(feedback);
		if(feedbackArray != null) {
			FeedbackModel resultObj = new FeedbackModel();
			resultObj.setResult(this.fileLocation, feedbackArray[0], feedbackArray[1], feedbackArray[2]);
			String jsonObjectResultString  = "{\"success\":" + resultObj.getSuccess()+ "}";
			return jsonObjectResultString;
		}
		return null;
	}
}