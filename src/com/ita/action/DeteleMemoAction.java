package com.ita.action;

import com.ita.action.base.UserBaseAction;
import com.ita.model.Memo;

public class DeteleMemoAction extends UserBaseAction{
	
	private Memo memo;
	
	private String tip;

	private String equ;
	
	public String getEqu() {
		return equ;
	}

	public void setEqu(String equ) {
		this.equ = equ;
	}

	public Memo getMemo() {
		return memo;
	}

	public void setMemo(Memo memo) {
		this.memo = memo;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception{
		userManager.deteleMemo(getMemo(), getEqu());
		setTip("detelesuccess");
		return SUCCESS;
	}
}