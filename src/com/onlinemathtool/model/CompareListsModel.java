package com.onlinemathtool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.onlinemathtool.helper.*;

public class CompareListsModel {
	private String list1;
	private String list2;
	private List<String> commonElements;
	private String list1Only;
	private String list2Only;
	private String list1OrList2;
	private Boolean success;
	
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
		List<String> listString1 = Helper.getStringList(_list1);
		List<String> listString2 = Helper.getStringList(_list2);
		if(listString1 != null && listString2 != null) {
			Set<String> setList1 = Helper.getSetFromList(listString1);
			setCommonElements(setList1, listString2);
			success = true;
		}
		else {
			success = false;
		}
		
	}
	
	public void setCommonElements(Set<String> setList1, List<String> list2) {
		commonElements = new ArrayList<String>();
		for(String s: list2) {
			if(setList1.contains(s)) {
				commonElements.add(s);
			}
		}
	}
	
	public List<String> getCommonElements() {
		return commonElements;
	}
	
	public void setSuccess(Boolean _success) {
		success = _success;
	}
	
	public Boolean getSuccess() {
		return success;
	}
}
