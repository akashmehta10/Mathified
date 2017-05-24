package com.onlinemathtool.model;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FeedbackModel {
	private String name;
	private String email;
	private String feedback;
	private Boolean success;
	
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
	
	public void setResult(String _name, String _email, String _feedback) {
		setName(_name);
		setEmail(_email);
		setFeedback(_feedback);
		try {
			List<String> lines = Arrays.asList("************",getName(), getEmail(), getFeedback());
			Path file = Paths.get("Feedback/feedback.txt");
	        System.out.println(FeedbackModel.class.getClassLoader().getResource("").getPath());
			System.out.println("Directory: " + Paths.get("Feedback/feedback.txt").toAbsolutePath().normalize().toString());
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			setSuccess(true);
		}
		catch(Exception exception) {
			setSuccess(false);
		}
	}
}
