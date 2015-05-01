package com.ita.action;


import com.ita.action.base.UserBaseAction;
import com.ita.model.Memo;
import com.opensymphony.xwork2.ActionContext;

public class SynAppidAction extends UserBaseAction{
	
	private Memo memo;
	
	
	private String tip;


	public void setMemo(Memo memo) {
		this.memo = memo;
	}
	public Memo	getMemo(){
		return this.memo;
	}

	
	public String getTip(){
		return this.tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute()throws Exception{
		userManager.SynAppid(getMemo());
		setTip("synsuccess");
		return SUCCESS;
	}
	
}