package com.onlinemathtool.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.onlinemathtool.helper.*;

public class CompareListsModel {
	private String list1;
	private String list2;
	private List<String> commonElements;
	private List<String> list1Only;
	private List<String> list2Only;
	private Set<String> list1OrList2;
	private Boolean success;
	private static final Logger logger = Logger.getLogger(CompareListsModel.class);
	
	public void setList1(String _list1) {
		list1 = _list1;
	}
	
	public String getList1() {
		return list1;
	}
	
	public void setList2(String _list2) {
		list2 = _list2;
	}
	
	public String getList2() {
		return list2;
	}
	
	public void setResult(String _list1, String _list2) {
		logger.info("Setting result to compare lists");
		List<String> listString1 = Helper.getStringList(_list1);
		List<String> listString2 = Helper.getStringList(_list2);
		if(listString1 != null && listString2 != null) {
			Set<String> setList1 = Helper.getSetFromList(listString1);
			Set<String> setList2 = Helper.getSetFromList(listString2);
			commonElements = new ArrayList<String>();
			list1Only = new ArrayList<String>();
			list2Only = new ArrayList<String>();
			list1OrList2 = new HashSet<String>();
			for(String s: setList1) {
				list1OrList2.add(s);
				if(setList2.contains(s)) {
					commonElements.add(s);
				}
				else {
					list1Only.add(s);
				}
			}
			for(String s: setList2) {
				list1OrList2.add(s);
				if(!setList1.contains(s)) {
					list2Only.add(s);
				}
			}
			success = true;
			logger.info("Done processing comparison of lists");
			logger.debug("Common elemets: " + commonElements);
			logger.debug("List 1 only elements: " + list1Only);
			logger.debug("List 2 only elements: " + list2Only);
			logger.debug("List 1 or List 2 elemets: " + list1OrList2);
		}
		else {
			success = false;
			logger.error("Error processing comparison of lists");
		}
	}
	
	public List<String> getCommonElements() {
		return commonElements;
	}
	
	public List<String> getList1Only() {
		return list1Only;
	}
	
	public List<String> getList2Only() {
		return list2Only;
	}
	
	public Set<String> getList1OrList2() {
		return list1OrList2;
	}
	
	public void setSuccess(Boolean _success) {
		success = _success;
	}
	
	public Boolean getSuccess() {
		return success;
	}
}
