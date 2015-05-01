package com.ita.action;

import com.ita.action.base.UserBaseAction;
import com.ita.model.Protector;
import com.opensymphony.xwork2.ActionContext;

public class AddProtectorAction extends UserBaseAction{
	
	private Protector protector;
	
	private String tip;

	
	public Protector getProtector() {
		return protector;
	}

	public void setProtector(Protector protector) {
		this.protector = protector;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String userEmail =(String)ctx.getSession().get(WebConstant.USER_EMAIL);
		userManager.addProtector(getProtector(), userEmail);
		setTip("addsuccess");
		return SUCCESS;
	}
}