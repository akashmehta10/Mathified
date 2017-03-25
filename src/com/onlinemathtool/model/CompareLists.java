package com.onlinemathtool.model;

import java.util.Set;

import com.onlinemathtool.helper.*;

public class CompareLists {
	private String list1;
	private String list2;
	private String commonElements;
	private String list1Only;
	private String list2Only;
	private String list1OrList2;
	
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
	
	public void setCommonElements(Set<String> setList1) {
		
	}
	
	public String getCommonElements() {
		return commonElements;
	}
}
