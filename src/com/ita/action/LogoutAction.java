package com.ita.action;

import com.ita.action.base.UserBaseAction;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends UserBaseAction{
	
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove(WebConstant.USER_EMAIL);
		setTip("logoutsuccess");
		return SUCCESS;
		
	}
}