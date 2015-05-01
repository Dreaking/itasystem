package com.ita.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import com.ita.action.base.UserBaseAction;
import com.ita.vo.ProtectorBean;
import com.opensymphony.xwork2.ActionContext;

public class UserProtectorAction extends UserBaseAction{
	
	private List<ProtectorBean> protectors =new ArrayList<ProtectorBean>();
	
	private String tip;

	public List<ProtectorBean> getProtectors() {
		return protectors;
	}

	public void setProtectors(List<ProtectorBean> protectors) {
		this.protectors = protectors;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		ActionContext ctx = ActionContext.getContext();		
		String userEmail=(String) ctx.getSession().get(WebConstant.USER_EMAIL);
		setProtectors(userManager.userProtectors(userEmail));
		setTip("loadsuccess");
		return SUCCESS;
	}
}