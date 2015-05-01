package com.ita.action;

import com.ita.action.base.UserBaseAction;
import com.ita.model.User;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends UserBaseAction{
	
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
		
		ActionContext ctx =ActionContext.getContext();
		int result= userManager.validLogin(user);
		if(result==1){
			ctx.getSession().put(WebConstant.USER_EMAIL, user.getEmail());
			setTip("loginsuccess");
			return SUCCESS;
		}
		else{
			setTip("loginerror");
			return SUCCESS;
		}
	}
	
}