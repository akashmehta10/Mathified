package com.onlinemathtool.model;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class FeedbackModel {
	private String name;
	private String email;
	private String feedback;
	private Boolean success;
	private static final Logger logger = Logger.getLogger(FeedbackModel.class);
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setEmail(String _email) {
		email = _email;
	}
	
	public void setFeedback(String _feedback) {
		feedback = _feedback;
	}
	
	public void setSuccess(Boolean _success) {
		success = _success;
	}
	
	public void setResult(String _fileLocation, String _name, String _email, String _feedback) {
		logger.info("Storing feedback");
		setName(_name);
		logger.debug("Name: " + name);
		setEmail(_email);
		logger.debug("Email: " + email);
		setFeedback(_feedback);
		logger.debug("Feedback: " + feedback);
		try {
			List<String> lines = Arrays.asList("************",getName(), getEmail(), getFeedback());
			logger.info("Feedback file location: " + _fileLocation);
			Path file = Paths.get(_fileLocation);
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			setSuccess(true);
			logger.info("Stored feedback");
		}
		catch(Exception exception) {
			setSuccess(false);
			logger.error("Error storing feedback");
			logger.error(exception.getMessage());
		}
	}
}
