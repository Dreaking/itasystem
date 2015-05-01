package com.ita.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.ita.action.base.UserBaseAction;
import com.ita.model.User;
import com.opensymphony.xwork2.ActionContext;

public class AddUserAction extends UserBaseAction{
	
	private User user;
	private String tip;
	
	//user的getter和setter方法
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//tip的getter和setter方法
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		userManager.addUser(user);
		setTip("registersuccess");
		return SUCCESS;
	}
	
}