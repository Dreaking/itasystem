package com.ita.action;

import com.ita.action.base.UserBaseAction;
import com.ita.model.Location;
import com.opensymphony.xwork2.ActionContext;

public class AddLocation extends UserBaseAction{
	
	private Location location;
	
	private String tip;
	
	
	//location的getter和setter方法
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
		
		
	}
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception{
		//获得session中的帐号
		ActionContext ctx = ActionContext.getContext();
		String userEmail = (String) ctx.getSession().get(WebConstant.USER_EMAIL);
		userManager.addLocation(getLocation(), userEmail);
		setTip("addsuccess");
		return SUCCESS;
	}
}