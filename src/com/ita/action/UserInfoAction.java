package com.ita.action;

import java.util.ArrayList;
import java.util.List;


import com.ita.action.base.UserBaseAction;
import com.ita.vo.LocationBean;
import com.ita.vo.UserBean;
import com.opensymphony.xwork2.ActionContext;

public class UserInfoAction extends UserBaseAction{
	private UserBean user;
	private String tips;

	//tips的getter和setter
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	
	public String execute() throws Exception{
		ActionContext ctx =ActionContext.getContext();
		
		String userEmail=(String)ctx.getSession().get(WebConstant.USER_EMAIL);
		
		setUser(userManager.userInfo(userEmail));

		setTips("loadsuccess");
		return SUCCESS;
	}
	
	
	
	
}