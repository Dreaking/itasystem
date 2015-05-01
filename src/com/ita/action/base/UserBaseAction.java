package com.ita.action.base;


import com.ita.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class UserBaseAction extends ActionSupport{
	
	protected UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	
	
	
}