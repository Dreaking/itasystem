package com.ita.action;

import com.opensymphony.xwork2.ActionContext;

public class LoginCheckAction extends UserLocationAction{
	private String tip;

	//tip的getter和setter
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String statement =(String)ctx.getSession().get(WebConstant.USER_EMAIL);
		if(statement==null){
			setTip("logout");
		}
		else{
			setTip("login");
		}
		return SUCCESS;
	}
}