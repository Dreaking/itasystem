package com.ita.action;



import com.ita.action.base.UserBaseAction;
import com.ita.model.Memo;
import com.opensymphony.xwork2.ActionContext;

public class AddMemoAction extends UserBaseAction{
	
	private Memo memo;
	
	
	private String tip;
	
	private String equ;


	public String getEqu() {
		return equ;
	}
	public void setEqu(String equ) {
		this.equ = equ;
	}
	
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
		ActionContext ctx = ActionContext.getContext();
		String userEmail =(String)ctx.getSession().get(WebConstant.USER_EMAIL);
		userManager.addMemo(getMemo(), userEmail,getEqu());
		setTip("addsuccess");
		return SUCCESS;
	}
	
}