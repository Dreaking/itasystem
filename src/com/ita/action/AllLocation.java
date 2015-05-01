package com.ita.action;

import java.util.ArrayList;
import java.util.List;


import com.ita.action.base.UserBaseAction;
import com.ita.vo.LocationBean;

public class AllLocation extends UserBaseAction{
	
	private String tip;
	private List<LocationBean> locations=new ArrayList<LocationBean>();

	public List<LocationBean> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationBean> locations) {
		this.locations = locations;
	}
	
	
	//tip的getter和setter方法
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		setLocations(userManager.allLocation());
		/*
		//转为JSON
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(locations);
		System.out.println(jsonArray.toString());
		*/
		setTip("loadsuccess");
		return SUCCESS;
	}
}