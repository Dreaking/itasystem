package com.ita.action;

import java.util.ArrayList;
import java.util.List;


import com.ita.action.base.UserBaseAction;
import com.ita.vo.LocationBean;
import com.opensymphony.xwork2.ActionContext;

public class UserLocationAction extends UserBaseAction{
	private List<LocationBean> locations = new ArrayList<LocationBean>();
	private String tips;

	//tips的getter和setter
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	//locations的getter和setter方法

	public List getLocations() {
		return locations;
	}

	public void setLocations(List locations) {
		this.locations = locations;
	}
	
	public String execute() throws Exception{
		ActionContext ctx =ActionContext.getContext();
		
		String userEmail=(String)ctx.getSession().get(WebConstant.USER_EMAIL);
		
		setLocations(userManager.userLocation(userEmail));
		/*
		//转为JSON
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(locations);
		System.out.println(jsonArray.toString());
		*/
		setTips("loadsuccess");
		return SUCCESS;
	}
	
	
	
	
}