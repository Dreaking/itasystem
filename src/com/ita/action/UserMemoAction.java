package com.ita.action;

import java.util.ArrayList;
import java.util.List;

import com.ita.action.base.UserBaseAction;
import com.ita.vo.MemoBean;
import com.opensymphony.xwork2.ActionContext;

public class UserMemoAction extends UserBaseAction{
	
	private List<MemoBean> memos= new ArrayList<MemoBean>();
	
	private String tip;

	public List<MemoBean> getMemos() {
		return memos;
	}

	public void setMemos(List<MemoBean> memos) {
		this.memos = memos;
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
		setMemos(userManager.userMemo(userEmail));
		setTip("loadsuccess");
		return SUCCESS;
	}
}